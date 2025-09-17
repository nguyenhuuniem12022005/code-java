import java.util.Scanner;

public class TongUocSo2 {

    private static final int MAX = 1000000;
    
    private static long[] sumOfProperDivisors = new long[MAX + 1];
    public static void sieveForDivisors() {
        for (int i = 1; i <= MAX; i++) {
    
            for (int j = 2 * i; j <= MAX; j += i) {
                sumOfProperDivisors[j] += i;
            }
        }
    }

    public static void main(String[] args) {
        sieveForDivisors();

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (sumOfProperDivisors[i] > i) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}