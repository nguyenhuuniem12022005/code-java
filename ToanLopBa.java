import java.util.Scanner;

public class ToanLopBa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String problem = sc.nextLine();
            System.out.println(solve(problem));
        }
    }

    public static String solve(String problem) {
        // Tách chuỗi input thành 5 phần
        String[] parts = problem.split(" ");
        String op1_pattern = parts[0];
        String op_pattern = parts[1];
        String op2_pattern = parts[2];
        // parts[3] là dấu "="
        String res_pattern = parts[4];

        char[] operators = {'+', '-', '*', '/'};

        // 1. Duyệt qua 4 toán tử
        for (char op : operators) {
            // Nếu toán tử trong input không phải '?' và không khớp, bỏ qua
            if (op_pattern.charAt(0) != '?' && op_pattern.charAt(0) != op) {
                continue;
            }

            // 2. Duyệt qua toán hạng 1 (từ 10 đến 99)
            // Ta duyệt qua từng chữ số (a, b)
            for (int a = 1; a <= 9; a++) { // Chữ số hàng chục của op1
                for (int b = 0; b <= 9; b++) { // Chữ số hàng đơn vị của op1
                    int op1 = a * 10 + b;

                    // Kiểm tra op1 có khớp với mẫu (pattern) không
                    if (op1_pattern.charAt(0) != '?' && op1_pattern.charAt(0) != (a + '0')) continue;
                    if (op1_pattern.charAt(1) != '?' && op1_pattern.charAt(1) != (b + '0')) continue;

                    // 3. Duyệt qua toán hạng 2 (từ 10 đến 99)
                    for (int c = 1; c <= 9; c++) { // Chữ số hàng chục của op2
                        for (int d = 0; d <= 9; d++) { // Chữ số hàng đơn vị của op2
                            int op2 = c * 10 + d;

                            // Kiểm tra op2 có khớp với mẫu (pattern) không
                            if (op2_pattern.charAt(0) != '?' && op2_pattern.charAt(0) != (c + '0')) continue;
                            if (op2_pattern.charAt(1) != '?' && op2_pattern.charAt(1) != (d + '0')) continue;

                            // 4. Tính toán kết quả
                            int res = 0;
                            boolean validOp = false;

                            if (op == '+') {
                                res = op1 + op2;
                                validOp = true;
                            } else if (op == '-') {
                                // Kết quả phải là số dương (đề bài)
                                if (op1 > op2) {
                                    res = op1 - op2;
                                    validOp = true;
                                }
                            } else if (op == '*') {
                                res = op1 * op2;
                                validOp = true;
                            } else if (op == '/') {
                                // Phép chia phải chia hết
                                if (op1 % op2 == 0) {
                                    res = op1 / op2;
                                    validOp = true;
                                }
                            }

                            if (!validOp) continue;

                            // 5. Kiểm tra kết quả phải là số có 2 chữ số (10-99)
                            if (res < 10 || res > 99) continue;

                            int e = res / 10; // Chữ số hàng chục của kết quả
                            int f = res % 10; // Chữ số hàng đơn vị của kết quả

                            // 6. Kiểm tra kết quả có khớp với mẫu (pattern) không
                            if (res_pattern.charAt(0) != '?' && res_pattern.charAt(0) != (e + '0')) continue;
                            if (res_pattern.charAt(1) != '?' && res_pattern.charAt(1) != (f + '0')) continue;

                            // Nếu tất cả kiểm tra đều qua, ta tìm thấy đáp án duy nhất
                            return String.format("%d %c %d = %d", op1, op, op2, res);
                        }
                    }
                }
            }
        }

        // Nếu không tìm thấy sau khi duyệt hết, trả về "WRONG PROBLEM!"
        return "WRONG PROBLEM!";
    }
}