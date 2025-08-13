import java.util.Scanner;

public class SapXepChon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // Tìm phần tử nhỏ nhất trong phần dãy còn lại
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Đổi chỗ phần tử nhỏ nhất về vị trí i
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
            // In ra trạng thái mảng sau mỗi bước
            System.out.printf("Buoc %d: ", i + 1);
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}