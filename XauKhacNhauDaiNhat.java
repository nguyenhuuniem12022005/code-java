import java.util.Scanner;

public class XauKhacNhauDaiNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            String a = scanner.next();
            String b = scanner.next();
            
            if (a.equals(b)) {
                System.out.println(-1);
            } else {
                System.out.println(Math.max(a.length(), b.length()));
            }
        }
        
        scanner.close();
    }
}