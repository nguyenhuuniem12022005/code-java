import java.math.BigInteger;
import java.util.Scanner;

public class BCNNSoLon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            BigInteger a = new BigInteger(scanner.next());
            BigInteger b = new BigInteger(scanner.next());
            
            BigInteger gcd = a.gcd(b);
            
            BigInteger lcm = a.multiply(b).divide(gcd);
            
            System.out.println(lcm.toString());
        }
        
        scanner.close();
    }
}