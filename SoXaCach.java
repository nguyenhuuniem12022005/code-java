import java.util.Scanner;

public class SoXaCach {

    /**
     * Hàm đệ quy để tìm các số xa cách.
     * @param N             Số chữ số mục tiêu.
     * @param currentNumStr Chuỗi số đang được xây dựng.
     * @param used          Mảng boolean đánh dấu các chữ số đã sử dụng.
     */
    private static void findSolutions(int N, String currentNumStr, boolean[] used) {
        // 1. ĐIỂM DỪNG: Nếu đã đủ N chữ số, đây là một kết quả.
        if (currentNumStr.length() == N) {
            System.out.println(currentNumStr);
            return;
        }

        // 2. BƯỚC ĐỆ QUY: Thử thêm một chữ số mới.
        // Lặp qua tất cả các chữ số từ 1 đến N
        for (int i = 1; i <= N; i++) {
            // Nếu chữ số i chưa được sử dụng
            if (!used[i]) {
                // Lấy chữ số cuối cùng của chuỗi hiện tại để kiểm tra điều kiện "xa cách"
                int lastDigit = currentNumStr.charAt(currentNumStr.length() - 1) - '0';

                // Nếu hiệu của chữ số mới (i) và chữ số cuối cùng không bằng 1
                if (Math.abs(i - lastDigit) != 1) {
                    // CHỌN: Đánh dấu chữ số i là đã dùng
                    used[i] = true;
                    // KHÁM PHÁ: Gọi đệ quy với chuỗi mới
                    findSolutions(N, currentNumStr + i, used);
                    // BỎ CHỌN (QUAY LUI): Bỏ đánh dấu để thử các khả năng khác
                    used[i] = false;
                }
            }
        }
    }

    /**
     * Hàm chính để xử lý mỗi test case.
     * @param n Số nguyên dương N.
     */
    public static void solve(int n) {
        boolean[] used = new boolean[n + 1]; // Mảng đánh dấu từ 1 đến n

        // Bắt đầu quá trình quay lui bằng cách thử từng chữ số đầu tiên
        for (int i = 1; i <= n; i++) {
            used[i] = true;
            findSolutions(n, String.valueOf(i), used);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            solve(n);
            // In dòng trống sau mỗi test case
            if (t > 0) {
                System.out.println();
            }
        }
        sc.close();
    }
}