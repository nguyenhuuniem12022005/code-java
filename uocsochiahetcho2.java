import java.util.Scanner;

public class uocsochiahetcho2{

    public static long demuoc(long n){
        if (n==1)
        {
            return 1;
        }
        long count=1;
        for (long i=2;i<=Math.sqrt(n);i++)
        {
            if (n%i==0)
            {
                long mu=0;
                while (n%i ==0){

                    mu++;
                    n/=i;
                }
                count *= (mu + 1);
            }
        }
        if (n > 1) {
            count *= 2; 
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while (t -->0)
        {
            long N = scanner.nextLong();
            if (N % 2 != 0) {
                System.out.println(0);
                continue;
            }
        
            long n_copy = N;
            int count2 = 0;
            while (n_copy % 2 == 0) {
                count2++;
                n_copy /= 2;
            }

            long k=demuoc(n_copy);
            long result = (k) * (count2);
            System.out.println(result);

        }
    }
}