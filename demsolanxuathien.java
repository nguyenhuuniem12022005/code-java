import java.util.*;

public class demsolanxuathien{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int cnt=0;
        while(n-->0){
            cnt+=1;
            int x= sc.nextInt();
            int[] a= new int[x];
            Map<Integer, Integer> mp= new HashMap<>();
            for (int i=0; i<x; i++){
                a[i]=sc.nextInt();
                mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
            }
            System.out.println("Test " + cnt + ":");
            for(int i=0; i<x; i++){
                if(mp.get(a[i])!= null){
                    System.out.println(a[i] + " xuat hien " + mp.get(a[i]) + " lan");
                    mp.remove(a[i]);
                }
            }
        }
    }
}