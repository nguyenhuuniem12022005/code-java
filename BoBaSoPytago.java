import java.util.*;

public class BoBaSoPytago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] a = new long[n];
            
            for (int j = 0; j < n; j++) { // Đổi i thành j
                long can = sc.nextLong();
                a[j] = can * can;
            }
            
            Arrays.sort(a);
            boolean check = false;
            
            for (int j = n - 1; j >= 2; j--) { // Đổi i thành j
                int r = j - 1;
                int l = 0;
                while (l < r) {
                    if (a[j] == a[l] + a[r]) {
                        check = true;
                        break;
                    } else if (a[j] < a[l] + a[r]) {
                        r--;
                    } else {
                        l++;
                    }
                }
                if (check) {
                    break;
                }
            }
            
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}