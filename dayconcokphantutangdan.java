import java.util.*;

public class dayconcokphantutangdan {
    static int N, K;
    static int[] A;
    static int[] daycon;

    static void indaycon(int st_i, int count) {
        if (count == K) {
            for (int i = 0; i < K; i++) {
                System.out.print(daycon[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = st_i; i < N; i++) {
            daycon[count] = A[i];
            indaycon(i + 1, count + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            N = sc.nextInt();
            K = sc.nextInt();
            A = new int[N];
            daycon = new int[K];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            Arrays.sort(A);

            indaycon(0, 0);
        }
        sc.close();
    }
}