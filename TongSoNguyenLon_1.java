import java.math.BigInteger;
import java.util.Scanner;

public class TongSoNguyenLon_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            String X = scanner.next();
            String Y = scanner.next();
            BigInteger numX = new BigInteger(X);
            BigInteger numY = new BigInteger(Y);
            BigInteger sum = numX.add(numY);
            System.out.println(sum.toString());
        }
        
        scanner.close();
    }
}