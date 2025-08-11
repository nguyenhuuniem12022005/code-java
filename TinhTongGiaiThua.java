import java.math.BigInteger;
import java.util.Scanner;

public class TinhTongGiaiThua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số n
        int n = scanner.nextInt();
        
        // Khởi tạo biến sum và factorial với kiểu BigInteger
        BigInteger sum = BigInteger.ZERO;
        BigInteger factorial = BigInteger.ONE;
        
        // Vòng lặp tính và cộng dồn giai thừa
        for (int i = 1; i <= n; i++) {
            // Cập nhật giá trị factorial: nhân với i
            factorial = factorial.multiply(BigInteger.valueOf(i));
            
            // Cộng factorial vào sum
            sum = sum.add(factorial);
        }
        
        // In kết quả
        System.out.println(sum);
        
        scanner.close();
    }
}