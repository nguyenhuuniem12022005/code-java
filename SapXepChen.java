import java.util.*;
public class SapXepChen{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        System.out.print("Buoc 0: ");
        for (int i=0;i<1;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for (int i=1;i<n;i++){
            long x=a[i];
            int j=i-1;
            while (j>=0 && a[j]>x){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=x;
            System.out.print("Buoc "+i+": ");
            for (int k=0;k<i+1;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
    }
}