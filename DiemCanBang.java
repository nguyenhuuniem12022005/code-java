import java.util.Scanner;

public class DiemCanBang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            long[] A = new long[N];
            
            long totalSum = 0;
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
                totalSum += A[i];
            }
            
            long leftSum = 0;
            boolean found = false;
            for (int i = 0; i < N; i++) {
                long rightSum = totalSum - leftSum - A[i];
                if (leftSum == rightSum) {
                    System.out.println(i + 1); 
                    found = true;
                    break;
                }
                
                leftSum += A[i];
            }
            
            if (!found) {
                System.out.println(-1);
            }
        }
        
        scanner.close();
    }
}