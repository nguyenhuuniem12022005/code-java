import java.util.Scanner;
import java.util.Stack;

public class PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            int N = scanner.nextInt();
            long[] A = new long[N];
            
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
            }
            
            Stack<Long> stack = new Stack<>();
            long[] result = new long[N];

            for (int i = N - 1; i >= 0; i--) {
                while (!stack.empty() && stack.peek() <= A[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
                stack.push(A[i]);
            }

            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}