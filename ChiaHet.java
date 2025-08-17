import java.math.BigInteger;
import java.util.Scanner;

public class ChiaHet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            BigInteger a = new BigInteger(scanner.next());
            BigInteger b = new BigInteger(scanner.next());

            //a.remainder(b): Phương thức này tính phần dư của phép chia a cho b.
            //equals(BigInteger.ZERO): So sánh kết quả của phép chia dư với số 0. Nếu bằng 0, nghĩa là phép chia hết.
            if (a.remainder(b).equals(BigInteger.ZERO) || b.remainder(a).equals(BigInteger.ZERO)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}