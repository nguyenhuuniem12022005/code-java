import java.util.*;
class NhanVien{
    private String ma;
    private String ten;
    private long luongthang;
    private long thuong;
    private long phucap;
    private long thuclinh;

    public NhanVien(int stt,String ten,long luongngay,int songaycong,String chucvu){
        this.ma="NV" + String.format("%02d",stt);
        this.luongthang=luongngay*songaycong;
        if (songaycong >=25){
            this.thuong=(long) (this.luongthang * 0.2);

        } else if (songaycong >=22){
            this.thuong=(long) (this.luongthang * 0.1);
        } else {
            this.thuong=0;
        }
        this.ten=ten;
        switch (chucvu){
            case "GD":
                this.phucap=250000;
                break;
            case "PGD":
                this.phucap=200000;
                break;
            case "TP":
                this.phucap=180000;
                break;
            case "NV":
                this.phucap=150000;
                break;
            default:
                this.phucap=0;
        }
        this.thuclinh=this.luongthang+this.thuong+this.phucap;
    }
        public long getThuclinh(){
            return this.thuclinh;
        }
        public String toString(){
            return ma + " " + ten + " " + luongthang + " " + thuong + " " + phucap + " " + thuclinh;
        }
    }


public class BangKeTienLuong{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<NhanVien> ds = new ArrayList<>();
        long tongchiphi=0;
        for (int i=0;i<n;i++){
            String ten = sc.nextLine();
            long luongngay = Long.parseLong(sc.nextLine());
            int songaycong = Integer.parseInt(sc.nextLine());
            String chucvu = sc.nextLine();
            ds.add(new NhanVien(i+1,ten,luongngay,songaycong,chucvu));
            tongchiphi += ds.get(i).getThuclinh();
        }
        for (NhanVien nv: ds){
            System.out.println(nv);
        }
        System.out.println("Tong chi phi tien luong: " + tongchiphi);
    }
}