import java.util.*;

public class boisonhonhatciuansonguyenduongdautien {
    public static long ucln(long a,long b){
        while(b!=0){
            long temp= b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static long bcnn(long a, long b){
        return a*b/ucln(a, b); 
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            long tmp=1;
            for(long i=2; i<=n; i++){
                tmp=bcnn(tmp, i);
            }
            System.out.println(tmp);
        }
    }

}
