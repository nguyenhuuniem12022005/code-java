import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner; 
class GiangVien implements Comparable<GiangVien>{
    private String ma;
    private String Hoten;
    private String bomon;
    private String ten;
    public GiangVien(int stt,String Hoten,String bomon){
        this.ma = "GV" + String.format("%02d", stt);
        this.Hoten = Hoten;
        this.bomon = viettat(bomon);
        this.ten = layten(Hoten);
    }
    private String layten(String Hoten){
        String[] parts = Hoten.split(" ");
        return parts[parts.length - 1];
    }
    private String viettat(String bomon){
        String[] parts = bomon.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String part : parts){
            sb.append(part.charAt(0));
        }
        return sb.toString().toUpperCase();
    }

    @Override
    public int compareTo(GiangVien o) {
        int compare_ten=this.ten.compareTo(o.ten);
        if(compare_ten!=0) return compare_ten;
        return this.ma.compareTo(o.ma);
    }
    public String toString() {
        return ma + " " + Hoten + " " + bomon;
    }
}
public class SapXepDanhSachGiangVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<GiangVien> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String boMon = sc.nextLine();
            danhSach.add(new GiangVien(i + 1, ten, boMon));
        }

        Collections.sort(danhSach);

        for (GiangVien gv : danhSach) {
            System.out.println(gv);
        }
        
        sc.close();
    }
}