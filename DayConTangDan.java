import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayConTangDan {
    public static void main(String[] args) {
        try {
            File file = new File("DAYSO.in");
            Scanner scanner = new Scanner(file);

            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            List<List<Integer>> resultList = new ArrayList<>();

            // Duyệt từ 1 đến 2^N - 1 để sinh tất cả các dãy con không rỗng
            for (int i = 1; i < (1 << n); i++) {
                List<Integer> currentSubsequence = new ArrayList<>();
                boolean isIncreasing = true;

                // Sử dụng bit mask để tạo dãy con
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        currentSubsequence.add(a[j]);
                    }
                }

                // Kiểm tra tính tăng dần và độ dài
                if (currentSubsequence.size() >= 2) {
                    for (int k = 1; k < currentSubsequence.size(); k++) {
                        if (currentSubsequence.get(k) <= currentSubsequence.get(k - 1)) {
                            isIncreasing = false;
                            break;
                        }
                    }
                    if (isIncreasing) {
                        resultList.add(currentSubsequence);
                    }
                }
            }

            // Sắp xếp các dãy con theo thứ tự từ điển
            Collections.sort(resultList, (list1, list2) -> {
                int minSize = Math.min(list1.size(), list2.size());
                for (int i = 0; i < minSize; i++) {
                    if (!list1.get(i).equals(list2.get(i))) {
                        return Integer.compare(list1.get(i), list2.get(i));
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            });

            // In kết quả
            for (List<Integer> sub : resultList) {
                for (int val : sub) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy file DAYSO.in");
        }
    }
}