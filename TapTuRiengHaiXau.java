import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TapTuRiengHaiXau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 

        while (t-- > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            String[] words1 = s1.trim().split("\\s+");
            String[] words2 = s2.trim().split("\\s+");
            Set<String> setS2 = new HashSet<>();
            for (String word : words2) {
                setS2.add(word);
            }

            Set<String> result = new TreeSet<>();
            for (String word : words1) {
                if (!setS2.contains(word)) {
                    result.add(word);
                }
            }

            for (String word : result) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}