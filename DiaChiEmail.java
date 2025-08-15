import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiaChiEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        Map<String, Integer> emailCount = new HashMap<>();

        while (n-- > 0) {
            String fullName = scanner.nextLine();
            String[] words = fullName.trim().toLowerCase().split("\\s+");
            StringBuilder email = new StringBuilder();
            email.append(words[words.length - 1]); 
            for (int i = 0; i < words.length - 1; i++) {
                email.append(words[i].charAt(0)); 
            }
            String baseEmail = email.toString();
            if (emailCount.containsKey(baseEmail)) {
                int count = emailCount.get(baseEmail) + 1;
                emailCount.put(baseEmail, count);
                System.out.printf("%s%d@ptit.edu.vn\n", baseEmail, count);
            } else {
                emailCount.put(baseEmail, 1);
                System.out.printf("%s@ptit.edu.vn\n", baseEmail);
            }
        }
        scanner.close();
    }
}