import java.util.Scanner;

public class TinhLuyThua {

    static final long MOD = 1000000007;

    public static long power(long a, long b) {
        long result = 1;
        a %= MOD; // Lấy dư a trước để tránh tràn số

        while (b > 0) {
            // Nếu b là số lẻ, nhân a vào kết quả
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            
            // Bình phương a và chia đôi b
            a = (a * a) % MOD;
            b /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();

            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(power(a, b));
        }

        scanner.close();
    }
}