import java.util.Scanner;

public class DayUuThe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            int evenCount = 0;
            int oddCount = 0;
            for (String num : numbers) {
                int value = Integer.parseInt(num);
                if (value % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            if ((evenCount > oddCount && (evenCount + oddCount) % 2 == 0) ||
                (oddCount > evenCount && (evenCount + oddCount) % 2 == 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}        



