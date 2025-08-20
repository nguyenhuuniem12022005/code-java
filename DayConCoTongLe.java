import java.util.*;

public class DayConCoTongLe {
    
    static int n;
    static Integer[] a;
    static List<List<Integer>> resultList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            // Bước 1: Sắp xếp dãy theo thứ tự giảm dần
            Arrays.sort(a, Collections.reverseOrder());
            
            resultList = new ArrayList<>();
            
            // Bước 2: Sinh tất cả các dãy con bằng quay lui
            generateSubsequences(0, new ArrayList<Integer>());
            
            // Bước 3: Sắp xếp các dãy con theo thứ tự từ điển
            Collections.sort(resultList, (list1, list2) -> {
                int minSize = Math.min(list1.size(), list2.size());
                for (int i = 0; i < minSize; i++) {
                    if (!list1.get(i).equals(list2.get(i))) {
                        return Integer.compare(list1.get(i), list2.get(i));
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            });
            
            // Bước 4: In kết quả
            for (List<Integer> sub : resultList) {
                for (int val : sub) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    // Hàm quay lui để sinh dãy con và kiểm tra tổng
    private static void generateSubsequences(int index, List<Integer> currentList) {
        if (index == n) {
            if (!currentList.isEmpty()) {
                long sum = 0;
                for (int val : currentList) {
                    sum += val;
                }
                if (sum % 2 != 0) {
                    resultList.add(new ArrayList<>(currentList));
                }
            }
            return;
        }
        
        // Không chọn phần tử a[index]
        generateSubsequences(index + 1, currentList);
        
        // Chọn phần tử a[index]
        currentList.add(a[index]);
        generateSubsequences(index + 1, currentList);
        currentList.remove(currentList.size() - 1);
    }
}