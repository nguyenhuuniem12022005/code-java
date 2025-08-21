import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ChuanHoaXauHoTenTrongFile {
    public static void main(String[] args) {
        try{
        File file=new File("DATA.in");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            if (s.equals("END")){
                break;
            }
            s=s.trim().toLowerCase();
            String[] w=s.split("\\s+");
            StringBuilder sb=new StringBuilder();
            for (String c:w){
                if (!c.isEmpty()){
                    String dau=c.substring(0,1).toUpperCase();
                    String tuconlai=c.substring(1);
                    sb.append(dau).append(tuconlai).append(" ");
                }
            }
            String standardizedName = sb.toString().trim();
            System.out.println(standardizedName);
        }
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file DATA.in");
        }
    }
}