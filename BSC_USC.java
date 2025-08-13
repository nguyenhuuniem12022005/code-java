import java.util.Scanner;

public class BSC_USC
{
    public static long ucln(long a, long b)
    {
        while (b != 0)
        {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long bcnn(long a, long b)
    {
        return (a * b) / ucln(a, b);
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-- >0)
        {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(bcnn(a, b)+ " " + ucln(a, b));
        }
    }
}