import java.util.Scanner;

public class KiemTraFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            long n = scanner.nextLong();
            if (n == 0) {
                System.out.println("YES");
                continue;
            }
            
            long a = 0;
            long b = 1;
            boolean isFib = false;
            while (b <= n) {
                if (b == n) {
                    isFib = true;
                    break;
                }
                long temp = a + b;
                a = b;
                b = temp;
            }
            
            if (isFib) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}