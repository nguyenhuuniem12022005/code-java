import java.util.*;
public class baitap1{
    private static int maxx=2000000;
    private static int[] thuasonguyento =new int[maxx+1];
    private static void sang(){
        for(int i=2;i<=maxx;i++){
            thuasonguyento[i]=i;
        }
        for(int i=2;i*i<=maxx;i++){
            if(thuasonguyento[i]==i){
                for(int j=i*i;j<=maxx;j+=i){
                    if(thuasonguyento[j]==j){
                        thuasonguyento[j]=i;
                    }
                }
            }
        }
    }
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        sang();
        long tong=0;
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int so=scanner.nextInt();
            while(so!=1){
                tong+=thuasonguyento[so];
                so/=thuasonguyento[so];
            }
        }
        System.out.println(tong);

    }
}