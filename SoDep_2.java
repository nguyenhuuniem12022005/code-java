import java.util.*;
public class SoDep_2{
    public static boolean kiemtra(String s){
        boolean check =true;
        if (s.charAt(0) != '8' || s.charAt(s.length()-1) != '8') check = false;
       
        
        int sum=0;
        for (char c : s.toCharArray()){
            sum += (c - '0');
        }
        if (sum %10 !=0) check = false;
        return check;
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
                
            }
            if (!kiemtra(s)){
                check = false;

            }


            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

