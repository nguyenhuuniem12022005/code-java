import java.util.Scanner;

public class XauNhiPhan {

    // Mảng lưu độ dài (số Fibonacci) của các xâu X[n]
    private static long[] fib = new long[93];

    // Hàm tiền xử lý để tính các số Fibonacci
    public static void precomputeFib() {
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= 92; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
    }

    // Hàm đệ quy để tìm ký tự thứ K trong xâu X[N]
    public static char findChar(int n, long k) {
        if (n == 1) {
            return '0';
        }
        if (n == 2) {
            return '1';
        }
        
        long length_n_2 = fib[n - 2];
        if (k <= length_n_2) {
            return findChar(n - 2, k);
        } else {
            return findChar(n - 1, k - length_n_2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        precomputeFib(); // Chạy hàm tiền xử lý một lần

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            System.out.println(findChar(n, k));
        }

        scanner.close();
    }
}