import java.math.BigInteger;
import java.util.*;

public class HieuHaiSoLon_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
            String X = scanner.next();
            String Y = scanner.next();
            BigInteger numX = new BigInteger(X);
            BigInteger numY = new BigInteger(Y);
            BigInteger result = numX.subtract(numY);
            String re= result.toString();
            
            System.out.print(re);
        }
        
       
    }
