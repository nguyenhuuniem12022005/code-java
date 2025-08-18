import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TimTuThuanNghich {
    
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversedString = sb.reverse().toString();
        return s.equals(reversedString);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> wordCounts = new LinkedHashMap<>();
        int maxLength = 0;
        while (sc.hasNext()) {
            String word = sc.next();
            if (isPalindrome(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                if (word.length() > maxLength) {
                    maxLength = word.length();
                }
            }
        }
        sc.close();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (word.length() == maxLength) {
                System.out.println(word + " " + count);
            }
        }
    }
}