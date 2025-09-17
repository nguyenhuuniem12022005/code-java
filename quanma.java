import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class quanma {
    private static final int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    static class Cell {
        int x, y, dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static int[] toCoords(String s) {
        int x = s.charAt(0) - 'a';
        int y = s.charAt(1) - '1';
        return new int[]{x, y};
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String startStr = sc.next();
            String endStr = sc.next();

            int[] start = toCoords(startStr);
            int[] end = toCoords(endStr);

            if (start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }

            Queue<Cell> queue = new LinkedList<>();
            boolean[][] visited = new boolean[8][8];

            queue.add(new Cell(start[0], start[1], 0));
            visited[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                Cell current = queue.poll();

                if (current.x == end[0] && current.y == end[1]) {
                    System.out.println(current.dist);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];

                    if (isValid(nextX, nextY) && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new Cell(nextX, nextY, current.dist + 1));
                    }
                }
            }
        }
        sc.close();
    }
}