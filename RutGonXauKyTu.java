import java.util.Scanner;
import java.util.Stack;

public class RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); 
            } else {
                stack.push(c); 
            }
        }
        
        if (stack.isEmpty()) {
            System.out.println("Empty String");
        } else {
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}