import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DayConTangDan {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        ArrayList<String> results = new ArrayList<>();
        for (int i = 1; i < (1 << n); i++) {
            ArrayList<Integer> currentSubsequence = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    currentSubsequence.add(a[j]);
                }
            }
            if (currentSubsequence.size() >= 2) {
                boolean isIncreasing = true;
                for (int k = 0; k < currentSubsequence.size() - 1; k++) {
                    if (currentSubsequence.get(k) >= currentSubsequence.get(k + 1)) {
                        isIncreasing = false;
                        break;
                    }
                }
                if (isIncreasing) {
                    StringBuilder sb = new StringBuilder();
                    for (int val : currentSubsequence) {
                        sb.append(val).append(" ");
                    }
                    results.add(sb.toString().trim());
                }
            }
        }
        Collections.sort(results);
        for (String s : results) {
            System.out.println(s);
        }
    }
}