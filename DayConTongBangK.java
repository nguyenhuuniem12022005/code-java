import java.util.Scanner;

public class DayConTongBangK {
    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = new long[n];
        boolean has_zero = false;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            if (a[i] == 0) {
                has_zero = true;
            }
        }

        if (k == 0) {
            if (has_zero) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return; 
        }

        int start = 0;
        long currentSum = 0;
        boolean found = false;

        for (int end = 0; end < n; end++) {
            currentSum += a[end];
            while (currentSum > k && start <= end) {
                currentSum -= a[start];
                start++;
            }
            if (currentSum == k) {
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }
}