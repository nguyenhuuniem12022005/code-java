import java.util.Scanner;

public class luachonthamlam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        sc.close();

        if (s == 0 && n > 1 || s > 9 * n) {
            System.out.println("-1 -1");
            return;
        }

        if (s == 0 && n == 1) {
            System.out.println("0 0");
            return;
        }

        StringBuilder snn = new StringBuilder();
        int tempS = s;
        int[] minDigits = new int[n];
        tempS--;
        for (int i = n - 1; i > 0; i--) {
            if (tempS >= 9) {
                minDigits[i] = 9;
                tempS -= 9;
            } else {
                minDigits[i] = tempS;
                tempS = 0;
            }
        }
        minDigits[0] = tempS + 1;
        for (int digit : minDigits) {
            snn.append(digit);
        }

        StringBuilder sln = new StringBuilder();
        tempS = s;
        for (int i = 0; i < n; i++) {
            if (tempS >= 9) {
                sln.append(9);
                tempS -= 9;
            } else {
                sln.append(tempS);
                tempS = 0;
            }
        }

        System.out.println(snn.toString() + " " + sln.toString());
    }
}