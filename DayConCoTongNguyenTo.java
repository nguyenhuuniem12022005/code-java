import java.util.*;

public class DayConCoTongNguyenTo {
    
    static int n;
    static int[] a;
    static boolean[] isPrime;
    static List<List<Integer>> resultList;
    static final int MAX_SUM = 1500;

    // Sàng số nguyên tố để kiểm tra nhanh
    public static void sieve() {
        isPrime = new boolean[MAX_SUM];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX_SUM; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX_SUM; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sieve();
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            // Sắp xếp dãy theo thứ tự giảm dần
            Arrays.sort(a);
            int[] sortedA = new int[n];
            for (int i = 0; i < n; i++) {
                sortedA[i] = a[n - 1 - i];
            }
            a = sortedA;
            
            resultList = new ArrayList<>();
            
            // Sinh tất cả các dãy con bằng quay lui
            generateSubsequences(0, new ArrayList<Integer>());
            
            // Sắp xếp các dãy con theo thứ tự từ điển tăng dần
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
        }
        
        scanner.close();
    }
    
    // Hàm quay lui để sinh dãy con và kiểm tra tổng
    private static void generateSubsequences(int index, List<Integer> currentList) {
        if (index == n) {
            if (!currentList.isEmpty()) {
                int sum = 0;
                for (int val : currentList) {
                    sum += val;
                }
                if (sum < MAX_SUM && isPrime[sum]) {
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