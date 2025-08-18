import java.util.*;
public class ChiaHetCho11{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        while (n-->0){
            String a = sc.nextLine();
            int len =a.length();
            long chan=0;
            long le=0;
            for (int i=0;i<len;i++){
                int digit = a.charAt(i) - '0';
                if (i % 2 == 0){
                    le += digit;
                }else {
                    chan += digit;
                }
            }
            if ((chan - le) % 11 == 0){
                System.out.println("1");
            }else {
                System.out.println("0");
            }
        }
    }
}