import java.util.Scanner;

public class ChiaTamGiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        while (T-- > 0) {

            int N = scanner.nextInt();
            double H = scanner.nextDouble();

            for (int i = 1; i < N; i++) {
                double hi = H * Math.sqrt((double) i / N);
                System.out.printf("%.6f", hi);
                if (i < N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}