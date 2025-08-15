import java.util.*;
public class SoDep_1{
    public static boolean chan(char c){
        return (c - '0') % 2 == 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0){
            String s= sc.next();
            boolean check=true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    check = false;
                    break;
                }
                
                if (!chan(s.charAt(i))) {
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
    }
}

