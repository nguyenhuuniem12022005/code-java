import java.util.Scanner;

public class tonguocso_1 {
    
    private static final int MAX = 2000000;
    private static int[] primeFactors = new int[MAX + 1];
    
    // Hàm sàng số nguyên tố để tìm ước số nguyên tố nhỏ nhất
    public static void sieve() {
        for (int i = 2; i <= MAX; i++) {
            primeFactors[i] = i;
        }
        
        for (int i = 2; i * i <= MAX; i++) {
            if (primeFactors[i] == i) { // i là số nguyên tố
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
        sieve(); // Chạy sàng một lần duy nhất
        
        long totalSum = 0;
        
        // Đọc số lượng số nguyên
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            
            // Phân tích và tính tổng các ước số nguyên tố
            while (num != 1) {
                totalSum += primeFactors[num];
                num /= primeFactors[num];
            }
        }
        
        System.out.println(totalSum);
        
        scanner.close();
    }
}