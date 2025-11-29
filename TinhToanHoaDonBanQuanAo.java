import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SanPham {
    String ma;
    String ten;
    long gia1;
    long gia2;

    public SanPham(String ma, String ten, long gia1, long gia2) {
        this.ma = ma;
        this.ten = ten;
        this.gia1 = gia1;
        this.gia2 = gia2;
    }
}

public class TinhToanHoaDonBanQuanAo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, SanPham> sanPhamMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long gia1 = Long.parseLong(sc.nextLine());
            long gia2 = Long.parseLong(sc.nextLine());
            sanPhamMap.put(ma, new SanPham(ma, ten, gia1, gia2));
        }

        int m = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= m; i++) {
            String maHoaDonBanDau = sc.next();
            long soLuong = sc.nextLong();
            if (sc.hasNextLine()) {
                sc.nextLine(); 
            }

            String maDayDu = String.format("%s-%03d", maHoaDonBanDau, i);


            String maSP = maHoaDonBanDau.substring(0, 2);
            char loai = maHoaDonBanDau.charAt(2);


            SanPham sp = sanPhamMap.get(maSP);
            String tenSP = sp.ten;
            
            long donGia = (loai == '1') ? sp.gia1 : sp.gia2;


            long thanhTien = donGia * soLuong;
            long giamGia = 0;

            if (soLuong >= 150) {
                giamGia = Math.round(thanhTien * 0.5);
            } else if (soLuong >= 100) {
                giamGia = Math.round(thanhTien * 0.3);
            } else if (soLuong >= 50) {
                giamGia = Math.round(thanhTien * 0.15);
            }

            long phaiTra = thanhTien - giamGia;

            System.out.println(maDayDu + " " + tenSP + " " + giamGia + " " + phaiTra);
        }

        sc.close();
    }
}