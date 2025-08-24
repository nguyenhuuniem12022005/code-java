import java.util.Arrays;
import java.util.Scanner;

public class KhoangCachNhoHonK {

    static int lower_bound(int[] a, int left, int key) {
        int index = a.length;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= key) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            int pos = lower_bound(a, i + 1, a[i] + k);

            count += (long) pos - i - 1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}