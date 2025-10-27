import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SanPham {
    private String maLoai;
    private String tenSP;
    private long donGia1;
    private long donGia2;

    public SanPham(String maLoai, String tenSP, long donGia1, long donGia2) {
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donGia1 = donGia1;
        this.donGia2 = donGia2;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getDonGia1() {
        return donGia1;
    }

    public long getDonGia2() {
        return donGia2;
    }
}

class HoaDon implements Comparable<HoaDon> {
    private String maHDDayDu;
    private String tenSP;
    private long giamGia;
    private long phaiTra;

    public HoaDon(String maHDGoc, int soLuong, int stt, Map<String, SanPham> spMap) {
        this.maHDDayDu = String.format("%s-%03d", maHDGoc, stt);
        
        String maLoaiSP = maHDGoc.substring(0, 2);
        char loai = maHDGoc.charAt(2);
        
        SanPham sp = spMap.get(maLoaiSP);
        this.tenSP = sp.getTenSP();
        
        long donGia = (loai == '1') ? sp.getDonGia1() : sp.getDonGia2();
        long thanhTien = donGia * soLuong;
        
        if (soLuong >= 150) {
            this.giamGia = (thanhTien * 50) / 100;
        } else if (soLuong >= 100) {
            this.giamGia = (thanhTien * 30) / 100;
        } else if (soLuong >= 50) {
            this.giamGia = (thanhTien * 15) / 100;
        } else {
            this.giamGia = 0;
        }
        
        this.phaiTra = thanhTien - this.giamGia;
    }

    @Override
    public int compareTo(HoaDon other) {
        // Sắp xếp giảm dần theo số tiền phải trả
        return Long.compare(other.phaiTra, this.phaiTra);
    }

    @Override
    public String toString() {
        return this.maHDDayDu + " " + this.tenSP + " " + this.giamGia + " " + this.phaiTra;
    }
}

public class SapXepHoaDonQuanAo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        Map<String, SanPham> spMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long gia1 = Long.parseLong(sc.nextLine());
            long gia2 = Long.parseLong(sc.nextLine());
            spMap.put(ma, new SanPham(ma, ten, gia1, gia2));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<HoaDon> dsHoaDon = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String maGoc = sc.next();
            int soLuong = sc.nextInt();
            dsHoaDon.add(new HoaDon(maGoc, soLuong, i, spMap));
        }
        
        Collections.sort(dsHoaDon);

        for (HoaDon hd : dsHoaDon) {
            System.out.println(hd);
        }
        
        sc.close();
    }
}