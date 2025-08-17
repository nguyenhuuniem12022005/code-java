import java.util.Scanner;

public class USCLN {

    // Hàm tìm ước số chung lớn nhất (ƯCLN)
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Hàm tìm bội số chung nhỏ nhất (BCNN)
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            
            long[] b = new long[n + 1];
            
            // Xây dựng dãy B
            b[0] = a[0];
            for (int i = 1; i < n; i++) {
                b[i] = lcm(a[i-1], a[i]);
            }
            b[n] = a[n-1];

            // In ra dãy B
            for (int i = 0; i <= n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}