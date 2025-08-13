import java.util.Scanner;

public class SoLienKe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số lượng bộ test
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            String n = scanner.next();
            boolean check = true;
            
            // Duyệt từ chữ số đầu tiên đến chữ số áp chót
            for (int i = 0; i < n.length() - 1; i++) {
                int digit1 = n.charAt(i) - '0';
                int digit2 = n.charAt(i + 1) - '0';
                
                // Kiểm tra nếu hiệu tuyệt đối của hai chữ số cạnh nhau khác 1
                if (Math.abs(digit1 - digit2) != 1) {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}