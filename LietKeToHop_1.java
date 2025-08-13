import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LietKeToHop_1 {
    static int n, k;
    static List<Integer> currentCombination = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        backtrack(1);

        System.out.printf("Tong cong co %d to hop\n", count);
        scanner.close();
    }

    public static void backtrack(int start) {
        if (currentCombination.size() == k) {
            count++;
            for (int i = 0; i < k; i++) {
                System.out.print(currentCombination.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}