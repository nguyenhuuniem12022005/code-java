import java.util.*;
class MatHang{
    private String mahang;
    private String tenhang;
    private long chietkhau;
    private long thanhtien;
    public MatHang(String mahang, String tenhang, long dongia, int soluong){
        this.mahang=mahang;
        this.tenhang=tenhang;
        double phantramck=0;
        if (soluong>10){
            phantramck=0.05;
        } else if (soluong >=8){
            phantramck=0.02;
        } else if (soluong >=5){
            phantramck=0.01;
        }
        this.chietkhau=(long) (dongia*soluong*phantramck);
        this.thanhtien=dongia*soluong-this.chietkhau;
    }
    public String toString(){
        return mahang + " " + tenhang + " " + chietkhau + " " + thanhtien;
    }
}
public class BangKeNhapKho{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> maHangCounter = new HashMap<>();
        List<MatHang> danhSachHang = new ArrayList<>();
        for (int i=0;i<n;i++){
            String ten=sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            long donGia = Long.parseLong(sc.nextLine());
            String[] p=ten.trim().split("\\s+");
            String m_p=(""+p[0].charAt(0)+p[1].charAt(0)).toUpperCase();
            int curr_c=maHangCounter.getOrDefault(m_p, 0);
            maHangCounter.put(m_p, curr_c + 1);
            String m_p_stt = String.format("%s%02d", m_p, curr_c + 1);
            MatHang matHang = new MatHang(m_p_stt, ten, donGia, soLuong);
            danhSachHang.add(matHang);
        }
        for (MatHang mh : danhSachHang) {
            System.out.println(mh);
        }
    }
}