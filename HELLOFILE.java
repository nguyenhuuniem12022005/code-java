import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HELLOFILE {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng File để trỏ đến tệp tin Hello.txt
            File file = new File("Hello.txt");
            
            // Tạo một đối tượng Scanner để đọc dữ liệu từ tệp tin
            Scanner scanner = new Scanner(file);
            
            // Đọc và in từng dòng trong tệp tin
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            // Đóng Scanner sau khi sử dụng
            scanner.close();
            
        } catch (FileNotFoundException e) {
            // Xử lý lỗi nếu không tìm thấy tệp tin
            System.out.println("Lỗi: Không tìm thấy tệp tin Hello.txt");
            e.printStackTrace();
        }
    }
}