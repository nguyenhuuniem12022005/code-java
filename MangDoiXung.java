import java.util.Scanner;

public class MangDoiXung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] arr = new long[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }
            
            boolean isSymmetric = true;
            for (int i = 0; i < n / 2; i++) {
                if (arr[i] != arr[n - 1 - i]) {
                    isSymmetric = false;
                    break;
                }
            }
            
            if (isSymmetric) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}