import java.util.Scanner;

public class CatDoi
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0)
        {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            boolean check =true;
            for (char c: s.toCharArray())
            {
                if (c=='0')
                {
                    sb.append('0');
                }
                else if (c=='1')
                {
                    sb.append('1');
                }
                else if (c=='8' || c=='9')
                {
                    sb.append('0');
                }
                else
                {
                    check = false;
                    break;
                }
            }
            if (!check)
            {
                System.out.println("INVALID");
            }
            else
            {
                String results=sb.toString().replaceFirst("^0*","");
                if (results.isEmpty())
                {
                    System.out.println("INVALID");
                }
                else
                {
                    System.out.println(results);
                }
            }
        }
    }
}
