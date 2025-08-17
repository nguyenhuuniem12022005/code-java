import java.util.Scanner;

public class DaoTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); 

        while (T-- > 0) {
            String str = scanner.nextLine();
            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();

            for (String word : words) {
                StringBuilder reversedWord = new StringBuilder(word);
                reversedWord.reverse();
                result.append(reversedWord).append(" ");
            }
            
            System.out.println(result.toString().trim());
        }
        scanner.close();
    }
}