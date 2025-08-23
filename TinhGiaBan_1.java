import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MatHang {
    private String maHang;
    private String tenHang;
    private String donVi;
    private long donGia;
    private int soLuong;
    private long phiVanChuyen;
    private long thanhTien;
    private long giaBan;

    public MatHang(int stt, String tenHang, String donVi, long donGia, int soLuong) {
        this.maHang = String.format("MH%02d", stt);
        this.tenHang = tenHang;
        this.donVi = donVi;
        this.donGia = donGia;
        this.soLuong = soLuong;
        tinhGiaBan();
    }

    private void tinhGiaBan() {
        long tongGiaNhap = donGia * soLuong;
        this.phiVanChuyen = Math.round(tongGiaNhap * 0.05);
        this.thanhTien = Math.round(tongGiaNhap + this.phiVanChuyen);
        this.giaBan = Math.round(this.thanhTien * 1.02);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", maHang, tenHang, donVi, phiVanChuyen, thanhTien, giaBan);
    }
}

public class TinhGiaBan_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<MatHang> danhSachMatHang = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tenHang = scanner.nextLine();
            String donVi = scanner.nextLine();
            long donGia = Long.parseLong(scanner.nextLine());
            int soLuong = Integer.parseInt(scanner.nextLine());
            danhSachMatHang.add(new MatHang(i + 1, tenHang, donVi, donGia, soLuong));
        }

        for (MatHang mh : danhSachMatHang) {
            System.out.println(mh);
        }
        
        scanner.close();
    }
}