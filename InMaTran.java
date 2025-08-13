import java.util.Scanner;

public class InMaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    // Duyệt từ trái qua phải cho hàng chẵn
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                } else {
                    // Duyệt từ phải qua trái cho hàng lẻ
                    for (int j = n - 1; j >= 0; j--) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}