import java.util.*;
public class CapSoCoTongBangK{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[]a=new long[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextLong();
            }
            Map<Long,Long> mp = new HashMap<>();
            long count=0;
            for (long num : a){
                long x= k-num;
                if (mp.containsKey(x)){
                    count += mp.get(x);
                }
                mp.put(num, mp.getOrDefault(num, 0L) + 1);
            }
            System.out.println(count);
        }
    }
}