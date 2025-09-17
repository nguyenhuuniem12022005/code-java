import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solocphat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            giai(N);
        }
        scanner.close();
    }

    public static void giai(int n) {
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> re = new ArrayList<>();

        queue.add("6");
        queue.add("8");
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (curr.length() > n) {
                continue;
            }
            
            re.add(curr);
            
            queue.add(curr + "6");
            queue.add(curr + "8");
        }

        Collections.reverse(re);
        
        System.out.println(re.size());
        for (String s : re) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}