import java.util.*;
public class BaiToanTuyenSinh{
    public static String formatNumber(double num){
        if (num == (long) num){
            return String.format("%d", (long) num);
        }
        return String.format("%.1f", num);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String maTS=sc.nextLine();
        String hoten=sc.nextLine();
        double diemToan=sc.nextDouble();
        double diemLy=sc.nextDouble();
        double diemHoa=sc.nextDouble();
        String kv=maTS.substring(0, 3);
        double diemuutien=0;
        if (kv.equals("KV1")){
            diemuutien=0.5;
        } else if (kv.equals("KV2")){
            diemuutien=1.0;
        } else if (kv.equals("KV3")){
            diemuutien=2.5;
        }
        double tongdiemchuauutien=diemToan*2+diemLy+diemHoa;
        double diemxettuyen=tongdiemchuauutien+diemuutien;
        String trangthai=(diemxettuyen >= 24) ? "TRUNG TUYEN" : "TRUOT";
        System.out.printf("%s %s %s %s %s\n", maTS, hoten, formatNumber(diemuutien), formatNumber(tongdiemchuauutien), trangthai);
    }
}