import java.util.*;
public class XauConLonNhat{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb= new StringBuilder();
        for (char c:s.toCharArray()){
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}