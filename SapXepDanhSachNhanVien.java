import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien> {
    private String maNV;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String maSoThue;
    private String ngayKyHopDong;

    public NhanVien(int stt, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKyHopDong) {
        this.maNV = String.format("%05d", stt);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKyHopDong = ngayKyHopDong;
    }
    public String getNgaySinhFormatted() {
        String[] parts = ngaySinh.split("/");
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
    
    @Override
    public int compareTo(NhanVien other) {
        return this.getNgaySinhFormatted().compareTo(other.getNgaySinhFormatted());
    }

    @Override
    public String toString() {
        return maNV + " " + hoTen + " " + gioiTinh + " " + ngaySinh + " " + diaChi + " " + maSoThue + " " + ngayKyHopDong;
    }
}

public class SapXepDanhSachNhanVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<NhanVien> danhSachNV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String hoTen = scanner.nextLine();
            String gioiTinh = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            String diaChi = scanner.nextLine();
            String maSoThue = scanner.nextLine();
            String ngayKyHopDong = scanner.nextLine();

            danhSachNV.add(new NhanVien(i + 1, hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKyHopDong));
        }

        Collections.sort(danhSachNV);

        for (NhanVien nv : danhSachNV) {
            System.out.println(nv);
        }
        
        scanner.close();
    }
}