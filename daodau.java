import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class daodau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);

        for (int i = 0; i < n && k > 0; i++) {
            if (a[i] < 0) {
                a[i] = -a[i];
                k--;
            } else {
                break;
            }
        }

        if (k > 0 && k % 2 != 0) {
            Arrays.sort(a);
            a[0] = -a[0];
        }

        long totalSum = LongStream.of(a).sum();
        System.out.println(totalSum);

        sc.close();
    }
}