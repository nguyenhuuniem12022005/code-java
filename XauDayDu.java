import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XauDayDu {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
        String s = sc.next();
        sc.nextLine();
        int k = sc.nextInt();
        Set<Character> Chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            Chars.add(c);
        }
        int Count = Chars.size();
        int Thieu_Count = 26 -Count;
        if (k >= Thieu_Count) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        }
        sc.close();
    }
}