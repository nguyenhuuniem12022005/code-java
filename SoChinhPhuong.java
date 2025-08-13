import java.util.Scanner;

public class SoChinhPhuong {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            long n = scanner.nextLong();
            long sqrtN = (long) Math.sqrt(n);
            if (sqrtN * sqrtN == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}