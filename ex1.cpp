#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <cstdint>

#ifdef _WIN32
#include <windows.h>
#else
#include <fcntl.h>
#include <unistd.h>
#endif

// -- Data Structures --
// These structures must be byte-aligned to correctly map to the raw data from the disk.
#pragma pack(push, 1)

/**
 * @struct PartitionEntry
 * @brief Represents a 16-byte entry in the MBR partition table.
 */
struct PartitionEntry {
    uint8_t status;               // 0x80 for bootable, 0x00 for non-bootable
    uint8_t chs_first_sector[3];  // CHS address of the first sector
    uint8_t type;                 // Partition type identifier
    uint8_t chs_last_sector[3];   // CHS address of the last sector
    uint32_t lba_first_sector;    // LBA of the first sector
    uint32_t sector_count;        // Number of sectors in the partition
};

/**
 * @struct MasterBootRecord
 * @brief Represents the 512-byte structure of a Master Boot Record.
 */
struct MasterBootRecord {
    uint8_t bootstrap_code[446];       // Bootloader code
    PartitionEntry partition_table[4]; // Array of 4 partition entries
    uint16_t boot_signature;           // Should be 0xAA55
};

#pragma pack(pop)
// -- End of Data Structures --


/**
 * @brief Converts a partition type code into a human-readable string.
 * @param type The partition type byte.
 * @return A string describing the partition type.
 */
std::string getPartitionTypeString(uint8_t type) {
    switch (type) {
        case 0x00: return "Empty";
        case 0x01: return "FAT12";
        case 0x04:
        case 0x06: return "FAT16";
        case 0x07: return "NTFS/exFAT";
        case 0x0B:
        case 0x0C: return "FAT32";
        case 0x05:
        case 0x0F: return "Extended";
        case 0x82: return "Linux Swap";
        case 0x83: return "Linux";
        case 0xAF: return "HFS/HFS+";
        case 0xEE: return "GPT Protective MBR";
        case 0xEF: return "EFI System Partition";
        default:
            std::stringstream ss;
            ss << "Unknown (0x" << std::hex << std::setw(2) << std::setfill('0') << (int)type << ")";
            return ss.str();
    }
}

/**
 * @brief Prints the details of a single partition entry.
 * @param entry The PartitionEntry to display.
 * @param index The index of the partition (0-3).
 */
void printPartitionInfo(const PartitionEntry& entry, int index) {
    long double partition_size_gb = (long double)entry.sector_count * 512.0 / (1024 * 1024 * 1024);

    std::cout << "--- Partition " << index << " ---" << std::endl;
    std::cout << "  Status:        " << (entry.status == 0x80 ? "Bootable (0x80)" : "Non-bootable (0x00)") << std::endl;
    std::cout << "  Type:          " << getPartitionTypeString(entry.type) << std::endl;
    std::cout << "  LBA Start:     " << entry.lba_first_sector << std::endl;
    std::cout << "  Sector Count:  " << entry.sector_count << std::endl;
    std::cout << "  Size:          " << std::fixed << std::setprecision(2) << partition_size_gb << " GB" << std::endl;
    std::cout << std::endl;
}


int main(int argc, char* argv[]) {
    std::string disk_path;
    unsigned char buffer[512];

#ifdef _WIN32
    // On Windows, the path is \\.\PhysicalDriveN
    int drive_index = 0;
    if (argc > 1) {
        drive_index = std::stoi(argv[1]);
    }
    disk_path = "\\\\.\\PhysicalDrive" + std::to_string(drive_index);

    HANDLE hDrive = CreateFileA(disk_path.c_str(),
                                GENERIC_READ,
                                FILE_SHARE_READ | FILE_SHARE_WRITE,
                                NULL,
                                OPEN_EXISTING,
                                0,
                                NULL);

    if (hDrive == INVALID_HANDLE_VALUE) {
        std::cerr << "Error: Could not open " << disk_path << "." << std::endl;
        std::cerr << "Please make sure you are running this program as an Administrator." << std::endl;
        return 1;
    }

    DWORD bytesRead;
    if (!ReadFile(hDrive, buffer, sizeof(buffer), &bytesRead, NULL) || bytesRead != 512) {
        std::cerr << "Error: Could not read the boot sector." << std::endl;
        CloseHandle(hDrive);
        return 1;
    }
    CloseHandle(hDrive);

#else
    // On Linux, the path is /dev/sdX
    if (argc > 1) {
        disk_path = argv[1];
    } else {
        disk_path = "/dev/sda"; // Default to the first SATA drive
    }

    int fd = open(disk_path.c_str(), O_RDONLY);
    if (fd < 0) {
        std::cerr << "Error: Could not open " << disk_path << "." << std::endl;
        std::cerr << "Please make sure the path is correct and you are running with sudo." << std::endl;
        return 1;
    }

    ssize_t bytes_read = read(fd, buffer, sizeof(buffer));
    if (bytes_read != 512) {
        std::cerr << "Error: Could not read the boot sector." << std::endl;
        close(fd);
        return 1;
    }
    close(fd);

#endif

    // Cast the buffer to our MBR structure
    MasterBootRecord* mbr = reinterpret_cast<MasterBootRecord*>(buffer);

    // Check for the MBR boot signature (0xAA55)
    if (mbr->boot_signature != 0xAA55) {
        std::cerr << "Error: Invalid boot signature (found 0x" << std::hex << mbr->boot_signature << ", expected 0xAA55)." << std::endl;
        std::cerr << "This may not be a valid MBR disk." << std::endl;
        return 1;
    }

    std::cout << "Successfully read boot sector from " << disk_path << std::endl;
    std::cout << "Boot Signature: 0x" << std::hex << mbr->boot_signature << " (Valid)" << std::endl << std::endl;
    std::cout << "----------- MBR Partition Table -----------" << std::endl;
    
    bool has_partitions = false;
    for (int i = 0; i < 4; ++i) {
        if (mbr->partition_table[i].type != 0x00) {
            has_partitions = true;
            printPartitionInfo(mbr->partition_table[i], i);
        }
    }
    
    if (!has_partitions) {
        std::cout << "No partitions found in the MBR partition table." << std::endl;
    }

    return 0;
}