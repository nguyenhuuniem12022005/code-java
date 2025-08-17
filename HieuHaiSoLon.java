import java.math.BigInteger;
import java.util.Scanner;

public class HieuHaiSoLon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            String X = scanner.next();
            String Y = scanner.next();
            
            BigInteger numX = new BigInteger(X);
            BigInteger numY = new BigInteger(Y);
            
            BigInteger result = numX.subtract(numY).abs();

            int max_len = Math.max(X.length(), Y.length());
            String re= result.toString();
            while(re.length() < max_len) {
                re = "0" + re;
            }
            System.out.println(re);
        }
        
        scanner.close();
    }
}