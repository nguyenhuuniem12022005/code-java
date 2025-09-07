import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            String n = scanner.next();
            boolean check = true;
            
            for (int i = 0; i < n.length() - 1; i++) {
                int CS1 = n.charAt(i) - '0';
                int CS2 = n.charAt(i + 1) - '0';
                
                if (Math.abs(CS1 - CS2) != 1) {
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