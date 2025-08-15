import java.util.Scanner;

public class ChuanHoaXauHoTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 

        while (t-- > 0) {
            String name = scanner.nextLine();
            name = name.trim().replaceAll("\\s+", " ");
            
            String[] words = name.split(" ");
            
            StringBuilder standardizedName = new StringBuilder();
            
            for (int i = 0; i < words.length; i++) {
                String word = words[i].toLowerCase();
                if (!word.isEmpty()) {
                    standardizedName.append(Character.toUpperCase(word.charAt(0)));
                    if (word.length() > 1) {
                        standardizedName.append(word.substring(1));
                    }
                    if (i < words.length - 1) {
                        standardizedName.append(" ");
                    }
                }
            }
            
            System.out.println(standardizedName.toString().trim());
        }
        scanner.close();
    }
}