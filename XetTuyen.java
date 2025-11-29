import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UngVien {
    private final String ma;
    private final String ten;
    private final int tuoi;
    private final int diemTrungBinh;
    private final String xepLoai;

    UngVien(int idx, String ten, String ngaySinh, double lyThuyet, double thucHanh) {
        this.ma = String.format("PH%02d", idx);
        this.ten = chuanHoaTen(ten);
        this.tuoi = 2021 - layNam(ngaySinh);
        double tong = (lyThuyet + thucHanh) / 2.0 + diemThuong(lyThuyet, thucHanh);
        long lamTron = Math.round(tong);
        if (lamTron > 10) {
            lamTron = 10;
        }
        this.diemTrungBinh = (int) lamTron;
        this.xepLoai = danhGia(this.diemTrungBinh);
    }

    private String chuanHoaTen(String raw) {
        String[] parts = raw.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0)));
                if (p.length() > 1) {
                    sb.append(p.substring(1));
                }
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    private int layNam(String date) {
        String[] parts = date.trim().split("/");
        return Integer.parseInt(parts[2]);
    }

    private double diemThuong(double lyThuyet, double thucHanh) {
        double min = Math.min(lyThuyet, thucHanh);
        if (min >= 8.0) {
            return 1.0;
        }
        if (min >= 7.5) {
            return 0.5;
        }
        return 0.0;
    }

    private String danhGia(int diem) {
        if (diem < 5) {
            return "Truot";
        }
        if (diem <= 6) {
            return "Trung binh";
        }
        if (diem == 7) {
            return "Kha";
        }
        if (diem == 8) {
            return "Gioi";
        }
        return "Xuat sac";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tuoi + " " + diemTrungBinh + " " + xepLoai;
    }
}

public class XetTuyen {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<UngVien> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double lyThuyet = Double.parseDouble(sc.nextLine().trim());
            double thucHanh = Double.parseDouble(sc.nextLine().trim());
            ds.add(new UngVien(i, ten, ngaySinh, lyThuyet, thucHanh));
        }
        StringBuilder sb = new StringBuilder();
        for (UngVien uv : ds) {
            sb.append(uv.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
