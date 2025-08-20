import java.util.Scanner;

public class ChuanHoaCau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc từng dòng cho đến khi hết input
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // Bỏ qua các dòng trống
            if (line.trim().isEmpty()) {
                continue;
            }

            // 1. Chuẩn hóa khoảng trắng và chuyển về chữ thường
            String processed = line.trim().toLowerCase().replaceAll("\\s+", " ");

            // 2. Viết hoa ký tự đầu tiên
            processed = processed.substring(0, 1).toUpperCase() + processed.substring(1);

            // 3. Xóa khoảng trắng thừa trước các dấu ngắt câu
            // Biểu thức chính quy này tìm một hoặc nhiều khoảng trắng (\\s+)
            // theo sau bởi một trong các dấu [.?!] và thay thế bằng chính dấu đó.
            processed = processed.replaceAll("\\s+([.?!])", "$1");

            // 4. Thêm dấu chấm nếu câu chưa kết thúc bằng dấu ngắt câu
            char lastChar = processed.charAt(processed.length() - 1);
            if (lastChar != '.' && lastChar != '?' && lastChar != '!') {
                processed += ".";
            }

            // 5. In câu đã chuẩn hóa
            System.out.println(processed);
        }

        sc.close();
    }
}