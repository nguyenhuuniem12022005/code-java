import java.util.Scanner;

public class XuLyVanBan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(" ");
        }
        sc.close();

        String vanban = sb.toString();
        String[] cau_tach = vanban.split("[.?!]");
        for (String sentence : cau_tach) {
            String cau_chinh_sua = sentence.trim().replaceAll("\\s+", " ");

            if (cau_chinh_sua.isEmpty()) {
                continue;
            }
            String chu_thuong = cau_chinh_sua.toLowerCase();
            String ky_tu_dau = chu_thuong.substring(0, 1).toUpperCase();
            String restOfSentence = chu_thuong.substring(1);
            String result = ky_tu_dau + restOfSentence;
            System.out.println(result);
        }
    }
}