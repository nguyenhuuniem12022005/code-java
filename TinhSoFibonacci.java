import java.util.Scanner;

public class TinhSoFibonacci {

    public static long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        long f0 = 1;
        long f1 = 1;
        long fn = 0;
        
        for (int i = 3; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(fibonacci(n));
        }

        scanner.close();
    }
}