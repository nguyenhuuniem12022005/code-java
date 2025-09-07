import java.math.BigInteger;
import java.util.Scanner;

public class TinhTongGiaiThua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        BigInteger sum = BigInteger.ZERO;
        BigInteger factorial = BigInteger.ONE;
        
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            
            sum = sum.add(factorial);
        }
        
        System.out.println(sum);
        
        scanner.close();
    }
}