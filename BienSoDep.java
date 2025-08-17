import java.util.Scanner;

public class BienSoDep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        while (T-- > 0) {
            String bienSo = scanner.nextLine();
            StringBuilder digitsOnly = new StringBuilder();

            // Lọc ra các ký tự chữ số
            for (char c : bienSo.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitsOnly.append(c);
                }
            }

            // Lấy 5 chữ số cuối cùng
            String phanSo = digitsOnly.toString().substring(digitsOnly.length() - 5);
            char[] digits = phanSo.toCharArray();

            boolean isYes = false;

            // Tiêu chí 1: 5 chữ số tăng chặt
            if (digits[0] < digits[1] && digits[1] < digits[2] && digits[2] < digits[3] && digits[3] < digits[4]) {
                isYes = true;
            }
            // Tiêu chí 2: 5 chữ số bằng nhau
            else if (digits[0] == digits[1] && digits[1] == digits[2] && digits[2] == digits[3] && digits[3] == digits[4]) {
                isYes = true;
            }
            // Tiêu chí 3: 3 chữ số đầu bằng nhau, 2 chữ số cuối bằng nhau
            else if (digits[0] == digits[1] && digits[1] == digits[2] && digits[3] == digits[4]) {
                isYes = true;
            }
            // Tiêu chí 4: Tất cả là 6 và/hoặc 8
            else {
                boolean isLocPhat = true;
                for (char c : digits) {
                    if (c != '6' && c != '8') {
                        isLocPhat = false;
                        break;
                    }
                }
                if (isLocPhat) {
                    isYes = true;
                }
            }

            if (isYes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}