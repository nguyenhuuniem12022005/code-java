import java.util.Scanner;

public class SoKhongLienKe {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        while (t-- > 0) {
            String n = scanner.next();
            
            // Biến cờ cho mỗi tính chất
            boolean tongChiaHetCho10 = true;
            boolean hieuBang2 = true;
            
            int sum = 0;
            
            // Kiểm tra tính chất 1: Tổng chữ số chia hết cho 10
            for (char c : n.toCharArray()) {
                sum += (c - '0');
            }
            if (sum % 10 != 0) {
                tongChiaHetCho10 = false;
            }
            
            // Kiểm tra tính chất 2: Các chữ số cạnh nhau khác nhau 2 đơn vị
            for (int i = 0; i < n.length() - 1; i++) {
                int digit1 = n.charAt(i) - '0';
                int digit2 = n.charAt(i + 1) - '0';
                
                if (Math.abs(digit1 - digit2) != 2) {
                    hieuBang2 = false;
                    break;
                }
            }
            
            // In kết quả
            if (tongChiaHetCho10 && hieuBang2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}