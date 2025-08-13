import java.util.Scanner;

public class Chuso4vaChuso7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        
        int count = 0;
        for (char c : n.toCharArray()) {
            if (c == '4' || c == '7') {
                count++;
            }
        }
        
        if (count == 4 || count == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}