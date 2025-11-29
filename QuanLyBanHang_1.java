import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KhachHang {
    static int dem = 1;
    String maKH;
    String tenKH;
    String gioiTinh;
    String ngaySinh;
    String diaChi;

    public KhachHang(String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = String.format("KH%03d", dem++);
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }
}

class MatHang {
    static int dem = 1;
    String maMH;
    String tenMH;
    String donViTinh;
    long giaMua;
    long giaBan;

    public MatHang(String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.maMH = String.format("MH%03d", dem++);
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
}

class HoaDon {
    static int dem = 1;
    String maHD;
    KhachHang kh;
    MatHang mh;
    int soLuong;
    long thanhTien;

    public HoaDon(KhachHang kh, MatHang mh, int soLuong) {
        this.maHD = String.format("HD%03d", dem++);
        this.kh = kh;
        this.mh = mh;
        this.soLuong = soLuong;
        this.thanhTien = mh.getGiaBan() * soLuong;
    }

    @Override
    public String toString() {
        return maHD + " " + kh.getTenKH() + " " + kh.getDiaChi() + " " +
               mh.getTenMH() + " " + mh.getDonViTinh() + " " +
               mh.getGiaMua() + " " + mh.getGiaBan() + " " +
               soLuong + " " + thanhTien;
    }
}

public class QuanLyBanHang_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, KhachHang> khachHangMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            KhachHang kh = new KhachHang(ten, gioiTinh, ngaySinh, diaChi);
            khachHangMap.put(kh.getMaKH(), kh);
        }

        int m = Integer.parseInt(sc.nextLine());
        Map<String, MatHang> matHangMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String ten = sc.nextLine();
            String dvt = sc.nextLine();
            long giaMua = Long.parseLong(sc.nextLine());
            long giaBan = Long.parseLong(sc.nextLine());
            MatHang mh = new MatHang(ten, dvt, giaMua, giaBan);
            matHangMap.put(mh.getMaMH(), mh);
        }

        int k = Integer.parseInt(sc.nextLine());
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String maKH = sc.next();
            String maMH = sc.next();
            int soLuong = sc.nextInt();
            
            KhachHang kh = khachHangMap.get(maKH);
            MatHang mh = matHangMap.get(maMH);
            
            hoaDonList.add(new HoaDon(kh, mh, soLuong));
        }


        for (HoaDon hd : hoaDonList) {
            System.out.println(hd);
        }

        sc.close();
    }
}