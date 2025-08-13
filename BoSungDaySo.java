import java.util.Scanner;

public class BoSungDaySo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        boolean isMissing = false;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int currentNumber = 1;
        for (int i = 0; i < n; i++) {
            while (currentNumber < arr[i]) {
                System.out.println(currentNumber);
                isMissing = true;
                currentNumber++;
            }
            currentNumber = arr[i] + 1;
        }
        while (currentNumber < arr[n-1] + 1) {
            currentNumber++;
        }
        
        if (currentNumber == arr[n-1] + 1 && !isMissing) {
            System.out.println("Excellent!");
        }
        
        scanner.close();
    }
}