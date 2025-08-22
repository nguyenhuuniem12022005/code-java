import java.util.*;
public class HinhSao{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] degree=new int [t];
        for (int i=0;i<t-1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            degree[u]++;
            degree[v]++;
        }
        int tam_degree=0;
        int la_degree=0;
        for (int i=1;i<=t;i++){
            if (degree[i]==t-1) {
                tam_degree++;
            } else if (degree[i]==1) {
                la_degree++;
            }

        }
        if (tam_degree==1 && la_degree==t-1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}