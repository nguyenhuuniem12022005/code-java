import java.util.*;

public class QuayHinhVuong {

    // Lớp để lưu trữ trạng thái và số bước
    static class State {
        int[] board;
        int moves;

        public State(int[] board, int moves) {
            this.board = board;
            this.moves = moves;
        }

        // Chuyển mảng thành chuỗi để dùng làm key trong HashSet
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i : board) {
                sb.append(i);
            }
            return sb.toString();
        }
    }

    // Hàm thực hiện phép quay hình vuông bên trái
    private static int[] rotateLeft(int[] board) {
        int[] next = Arrays.copyOf(board, 6);
        int temp = next[0];
        next[0] = next[3];
        next[3] = next[4];
        next[4] = next[1];
        next[1] = temp;
        return next;
    }

    // Hàm thực hiện phép quay hình vuông bên phải
    private static int[] rotateRight(int[] board) {
        int[] next = Arrays.copyOf(board, 6);
        int temp = next[1];
        next[1] = next[4];
        next[4] = next[5];
        next[5] = next[2];
        next[2] = temp;
        return next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int[] initial = new int[6];
            int[] target = new int[6];

            for (int i = 0; i < 6; i++) initial[i] = scanner.nextInt();
            for (int i = 0; i < 6; i++) target[i] = scanner.nextInt();

            String targetStr = new State(target, 0).toString();

            Queue<State> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            State initialState = new State(initial, 0);
            queue.add(initialState);
            visited.add(initialState.toString());

            int result = 0;
            while (!queue.isEmpty()) {
                State currentState = queue.poll();

                if (currentState.toString().equals(targetStr)) {
                    result = currentState.moves;
                    break;
                }

                // Quay trái
                int[] nextLeft = rotateLeft(currentState.board);
                State nextLeftState = new State(nextLeft, currentState.moves + 1);
                if (!visited.contains(nextLeftState.toString())) {
                    visited.add(nextLeftState.toString());
                    queue.add(nextLeftState);
                }

                // Quay phải
                int[] nextRight = rotateRight(currentState.board);
                State nextRightState = new State(nextRight, currentState.moves + 1);
                if (!visited.contains(nextRightState.toString())) {
                    visited.add(nextRightState.toString());
                    queue.add(nextRightState);
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}