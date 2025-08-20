import java.util.Scanner;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String maSoThue;
    private String ngayKyHopDong;
    public NhanVien(String hoTen, String gioiTinh, String ngaySinh, String diaChi, String maSoThue, String ngayKyHopDong) {
        this.maNhanVien = "00001";
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.ngayKyHopDong = ngayKyHopDong;
    }
    public String toString() {
        return this.maNhanVien + " " +
               this.hoTen + " " +
               this.gioiTinh + " " +
               this.ngaySinh + " " +
               this.diaChi + " " +
               this.maSoThue + " " +
               this.ngayKyHopDong;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoTen = sc.nextLine();
        String gioiTinh = sc.nextLine();
        String ngaySinh = sc.nextLine();
        String diaChi = sc.nextLine();
        String maSoThue = sc.nextLine();
        String ngayKyHopDong = sc.nextLine();
        NhanVien nv = new NhanVien(hoTen, gioiTinh, ngaySinh, diaChi, maSoThue, ngayKyHopDong);
        System.out.println(nv);

        sc.close();
    }
}
