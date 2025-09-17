import java.util.Scanner;
import java.util.Stack;

public class dautuchungkhoan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int[] spans = new int[n];

            for (int i = 0; i < n; i++) {
                while (!stack.empty() && prices[stack.peek()] <= prices[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    spans[i] = i + 1;
                } else {
                    spans[i] = i - stack.peek();
                }

                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(spans[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}