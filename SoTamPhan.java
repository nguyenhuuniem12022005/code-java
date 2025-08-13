import java.util.*;
public class SoTamPhan{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t= scanner.nextInt();
        while (t -->0)
        {
            String s = scanner.next();
            boolean check=true;
            for (char c: s.toCharArray()){
                if (c -'0' >2){
                    check=false;
                }
            }
            System.out.println(check?"YES":"NO");
        }
    }
}