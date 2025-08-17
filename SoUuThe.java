import java.util.*;
public class SoUuThe{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            String s=sc.next();
            boolean check=true;
            if (s.charAt(0)=='0'){
                check=false;
            }
            else{
                for (int i=0;i<s.length();i++){
                    if (!Character.isDigit(s.charAt(i))){
                        check=false;
                    }
                }
            }
            if (!check){
                System.out.println("INVALID");
                continue;
            }
            int chan=0;
            int le=0;
            for (char c:s.toCharArray()){
                int digit=c-'0';
                if (digit%2==0){
                    chan++;
                }else {
                    le++;
                }
            }
            int len=s.length();
            if (len%2==0){
                if (chan>le){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else{
                if (le>chan){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }

        }
    }
}