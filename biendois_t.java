import java.util.Scanner;

public class biendois_t {
    public static int giai(int s, int t) {
        if (s >= t) {
            return s - t;
        }
        
        int count = 0;
        while (t > s) {
            if (t % 2 == 0) {
                t /= 2;
            } else {
                t += 1;
            }
            count++;
        }
        return count + (s - t);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int S = scanner.nextInt();
            int t = scanner.nextInt();
            System.out.println(giai(S, t));
        }
        scanner.close();
    }
}