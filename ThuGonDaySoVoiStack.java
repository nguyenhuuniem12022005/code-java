import java.util.Scanner;
import java.util.Stack;

public class ThuGonDaySoVoiStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int currentNum = scanner.nextInt();
            
            // Nếu stack không rỗng và tổng là chẵn
            if (!stack.isEmpty() && (stack.peek() + currentNum) % 2 == 0) {
                stack.pop(); // Loại bỏ phần tử trên cùng
            } else {
                stack.push(currentNum); // Thêm phần tử hiện tại vào stack
            }
        }
        
        System.out.println(stack.size());
        
        scanner.close();
    }
}