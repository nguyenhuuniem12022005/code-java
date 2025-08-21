import java.util.*;
class NhanVien{
    private String id;
    private String name;
    private long luongngay;
    private int songaylam;
    private String chucvu;
    public NhanVien(String name,long luongngay,int songaylam,String chucvu){
        this.id = "NV01";
        this.name = name;
        this.luongngay = luongngay;
        this.songaylam = songaylam;
        this.chucvu = chucvu;
    }
    public long getLuongthang(){
        return luongngay * songaylam;
    }
    public long getBonus(){
        long luong=getLuongthang();
        if (songaylam >=25){
            return luong *20/100;
        }else if (songaylam >= 22) {
            return luong * 10 / 100;
        }else {
            return 0;
        }
    }
    public long getPhucap(){
        switch (chucvu) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            case "NV":
                return 150000;
            default:
                return 0;
        }
    }
    public long getTongthunhap(){
        return getLuongthang() + getBonus() + getPhucap();
    }
    public String toString(){
        return   id + " " + name + " " + getLuongthang() + " " + getBonus() + " " + getPhucap() + " " + getTongthunhap();
    }

}
public class BaiToanTinhCong{
    public static void main(String[]args){
        Scanner sc= new Scanner (System.in);
        String ten = sc.nextLine();
        long luongngay = sc.nextLong();
        int songaylam = sc.nextInt();
        String chucvu = sc.next();
        NhanVien nv = new NhanVien(ten, luongngay, songaylam, chucvu);
        System.out.println(nv);
    }
}