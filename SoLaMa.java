import java.util.Scanner;

public class SoLaMa {
    public static int getValue(char r) {
        switch (r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int result = 0;
            int lastValue = 0; 
            for (int i = s.length() - 1; i >= 0; i--) {
                char currentChar = s.charAt(i);
                int currentValue = getValue(currentChar);
                if (currentValue < lastValue) {
                    result -= currentValue;
                } 
                else {
                    result += currentValue;
                }
                lastValue = currentValue;
            }
            System.out.println(result);
        }
        sc.close();
    }
}