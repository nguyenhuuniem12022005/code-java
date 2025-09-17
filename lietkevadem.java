import java.util.*;

public class lietkevadem {

    public static boolean isNonDecreasing(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> counts = new LinkedHashMap<>();
        
        while (sc.hasNext()) {
            String s = sc.next();
            if (isNonDecreasing(s)) {
                counts.put(s, counts.getOrDefault(s, 0) + 1);
            }
        }

        List<String> sortedKeys = new ArrayList<>(counts.keySet());
        sortedKeys.sort((a, b) -> counts.get(b) - counts.get(a));

        for (String key : sortedKeys) {
            System.out.println(key + " " + counts.get(key));
        }

        sc.close();
    }
}