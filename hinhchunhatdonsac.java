import java.util.Scanner;
import java.util.Stack;

public class hinhchunhatdonsac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        int n = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            b[i] = m - a[i];
        }

        long maxYellow = largestRectangleArea(a);
        long maxBlue = largestRectangleArea(b);
        
        System.out.println(Math.max(maxYellow, maxBlue));
        scanner.close();
    }

    public static long largestRectangleArea(long[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                long height = heights[stack.pop()];
                long width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = heights[stack.pop()];
            long width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}