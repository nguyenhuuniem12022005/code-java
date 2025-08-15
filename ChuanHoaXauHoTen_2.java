import java.util.*;
public class ChuanHoaXauHoTen_2{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0){
            String ten=sc.nextLine().trim().toLowerCase();
            String[] tu=ten.split("\\s+");
            String ho=tu[0].toUpperCase();
            StringBuilder sb=new StringBuilder();
            for (int i=1; i<tu.length; i++){
                String s = tu[i];
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
                if (i < tu.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append(", ").append(ho);
            
            System.out.println(sb.toString().trim());
        }
    }
}