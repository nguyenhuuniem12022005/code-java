import java.util.*;
public class XauDoiXung{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            String s=sc.next();
            int len=s.length();
            int dem=0;
            for (int i=0;i<len/2;i++){
                if (s.charAt(i) != s.charAt(len-1-i)){
                    dem++;
                }
            }
            if (dem ==1){
                System.out.println("YES");
            }else if (dem==0 && len%2==1) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}