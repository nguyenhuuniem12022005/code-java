import java.util.Scanner;

public class QuayPhai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            int N = scanner.nextInt();
            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
            }
            
            int k = 0;
            for (int i = 1; i < N; i++) {
                if (A[i] < A[i - 1]) {
                    k = i;
                    break;
                }
            }
            
            System.out.println(k);
        }
        
        scanner.close();
    }
}