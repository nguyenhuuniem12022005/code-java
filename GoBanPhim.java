import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class GoBanPhim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> left = new ArrayDeque<>();

        Deque<Character> right = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '<': 
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case '>': 
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case '-': 
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                default: 
                    left.push(c);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();

        while (!left.isEmpty()) {
            result.append(left.removeLast());
        }

        while (!right.isEmpty()) {
            result.append(right.pop());
        }

        System.out.println(result.toString());
    }
}