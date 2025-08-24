import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class SV{
    private int stt;
    private String ma,hoten,lop,email,doanhnghiep;
    public SV(int stt, String ma, String hoten, String lop, String email, String doanhnghiep) {
        this.stt = stt;
        this.ma = ma;
        this.hoten = hoten;
        this.lop = lop;
        this.email = email;
        this.doanhnghiep = doanhnghiep;
    }
    public String getMa() {
        return ma;
    }
    public String getHoTen() {
        return hoten;
    }
    public String getLop() {
        return lop;
    }
    public String getEmail() {
        return email;
    }
    public String getDoanhNghiep() {
        return doanhnghiep;
    }
    public String toString(){
        return stt + " " + ma + " " + hoten + " " + lop + " " + email + " " + doanhnghiep;
    }
}
public class DanhSachThucTap_1{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<SV> danhSachGoc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String dn = sc.nextLine();
            danhSachGoc.add(new SV(i + 1, ma, ten, lop, email, dn));
        }

        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String tenDoanhNghiep = sc.nextLine();

            List<SV> danhSachLoc = new ArrayList<>();
            for (SV sv : danhSachGoc) {
                if (sv.getDoanhNghiep().equals(tenDoanhNghiep)) {
                    danhSachLoc.add(sv);
                }
            }

            danhSachLoc.sort(Comparator.comparing(SV::getHoTen));

            for (SV sv : danhSachLoc) {
                System.out.println(sv);
            }
        }
        sc.close();
    }
}