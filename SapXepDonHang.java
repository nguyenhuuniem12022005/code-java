import java.util.*;
class DonHang implements Comparable<DonHang>{
    private String tenhang;
    private String madonhang;
    private String sothutu;
    private long giamgia;
    private long thanhtien;

    public DonHang(String tenhang,String madonhang,long dongia,int soluong){
        this.tenhang=tenhang;
        this.madonhang=madonhang;
        this.sothutu=madonhang.substring(1,4);
        char maloai=madonhang.charAt(4);
        long tongtien = dongia * soluong;
        if (maloai =='1'){
            this.giamgia=(long) (tongtien * 0.5);
        } else {
            this.giamgia=(long) (tongtien * 0.3);
        }
        this.thanhtien=tongtien-this.giamgia;
    }
    public int compareTo(DonHang other) {
        return this.sothutu.compareTo(other.sothutu);
    }
    public String toString(){
        return tenhang + " " + madonhang + " " + sothutu + " " + giamgia + " " + thanhtien;
    }
}
public class SapXepDonHang{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<DonHang> donHangList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String ma = sc.nextLine();
            long donGia = Long.parseLong(sc.nextLine());
            int soLuong = Integer.parseInt(sc.nextLine());
            DonHang dh = new DonHang(ten, ma, donGia, soLuong);
            donHangList.add(dh);
        }
        Collections.sort(donHangList);
        for (DonHang dh : donHangList) {
            System.out.println(dh);
        }
        sc.close();
    }
}