import java.util.Scanner;

public class UocSoNguyenToLonNhat {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            long n = scanner.nextLong();
            long maxPrimeFactor = -1;
            
            // Xử lý thừa số 2
            while (n % 2 == 0) {
                maxPrimeFactor = 2;
                n /= 2;
            }
            
            // Xử lý các thừa số lẻ
            for (long i = 3; i * i <= n; i += 2) {
                while (n % i == 0) {
                    maxPrimeFactor = i;
                    n /= i;
                }
            }
            
            // Xử lý trường hợp N là số nguyên tố
            if (n > 2) {
                maxPrimeFactor = n;
            }
            
            System.out.println(maxPrimeFactor);
        }
        
        scanner.close();
    }
}