import java.util.Arrays;
import java.util.Scanner;

public class MaTranXoanOcTangDan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sắp xếp các phần tử theo thứ tự tăng dần
        Arrays.sort(arr);

        int[][] result = new int[n][n];
        int k = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Điền từ trái sang phải
            for (int i = left; i <= right; i++) {
                result[top][i] = arr[k++];
            }
            top++;

            // Điền từ trên xuống dưới
            for (int i = top; i <= bottom; i++) {
                result[i][right] = arr[k++];
            }
            right--;

            // Điền từ phải sang trái
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = arr[k++];
                }
                bottom--;
            }

            // Điền từ dưới lên trên
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = arr[k++];
                }
                left++;
            }
        }

        // In ma trận kết quả
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}