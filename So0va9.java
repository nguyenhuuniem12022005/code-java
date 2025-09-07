import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class So0va9 {

   
    public static String solve(int n) {
        Queue<Integer> q = new LinkedList<>();
        
        int[] parent = new int[n];

        char[] digit = new char[n];
        
        boolean[] visited = new boolean[n];

        int startRem = 9 % n;
        if (startRem == 0) {
            return "9";
        }
        
        q.add(startRem);
        visited[startRem] = true;
        digit[startRem] = '9';
        parent[startRem] = -1; 

        while (!q.isEmpty()) {
            int currentRem = q.poll();

            int nextRem0 = (currentRem * 10) % n;
            if (!visited[nextRem0]) {
                visited[nextRem0] = true;
                parent[nextRem0] = currentRem;
                digit[nextRem0] = '0';
                q.add(nextRem0);
                if (nextRem0 == 0) {
                    break;
                }
            }
            
            int nextRem9 = (currentRem * 10 + 9) % n;
            if (!visited[nextRem9]) {
                visited[nextRem9] = true;
                parent[nextRem9] = currentRem;
                digit[nextRem9] = '9';
                q.add(nextRem9);
                if (nextRem9 == 0) {
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int rem = 0;
        while (rem != -1) {
            result.append(digit[rem]);
            rem = parent[rem];
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
        sc.close();
    }
}