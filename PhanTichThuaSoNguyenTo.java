import java.util.Scanner;

public class PhanTichThuaSoNguyenTo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số bộ test
        int t = scanner.nextInt();
        
        // Lặp qua từng bộ test
        for (int test = 1; test <= t; test++) {
            long n = scanner.nextLong();
            System.out.printf("Test %d: ", test);
            
            // Xử lý thừa số 2
            int count = 0;
            while (n % 2 == 0) {
                count++;
                n /= 2;
            }
            if (count > 0) {
                System.out.printf("2(%d) ", count);
            }
            
            // Xử lý các thừa số lẻ
            for (long i = 3; i * i <= n; i += 2) {
                count = 0;
                while (n % i == 0) {
                    count++;
                    n /= i;
                }
                if (count > 0) {
                    System.out.printf("%d(%d) ", i, count);
                }
            }
            
            // Xử lý trường hợp n là số nguyên tố còn lại
            if (n > 1) {
                System.out.printf("%d(%d)", n, 1);
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}