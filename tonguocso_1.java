import java.util.Scanner;

public class tonguocso_1 {
    
    private static final int MAX = 2000000;
    private static int[] primeFactors = new int[MAX + 1];
    
    public static void sieve() {
        for (int i = 2; i <= MAX; i++) {
            primeFactors[i] = i;
        }
        
        for (int i = 2; i * i <= MAX; i++) {
            if (primeFactors[i] == i) { 
                for (int j = i * i; j <= MAX; j += i) {
                    if (primeFactors[j] == j) {
                        primeFactors[j] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sieve(); 
        
        long totalSum = 0;
        
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            
            while (num != 1) {
                totalSum += primeFactors[num];
                num /= primeFactors[num];
            }
        }
        
        System.out.println(totalSum);
        
        scanner.close();
    }
}