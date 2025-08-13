import java.util.Scanner;

public class TichMaTranChuyenVi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            int[][] a_T = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a_T[j][i] = a[i][j];
                }
            }

            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) { 
                    for (int k = 0; k < m; k++) { 
                        result[i][j] += a[i][k] * a_T[k][j];
                    }
                }
            }

            System.out.println("Test " + t + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}