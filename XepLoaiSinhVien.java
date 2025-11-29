import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SinhVienXL {
    private final String ma;
    private final String ten;
    private final double tongKet;
    private final String xepLoai;

    SinhVienXL(int idx, String tenRaw, int luyenTap, int thucHanh, int thi) {
        this.ma = String.format("SV%02d", idx);
        this.ten = chuanHoaTen(tenRaw);
        this.tongKet = luyenTap * 0.25 + thucHanh * 0.35 + thi * 0.4;
        this.xepLoai = tinhXepLoai(this.tongKet);
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

    private String tinhXepLoai(double diem) {
        if (diem >= 8.0) {
            return "GIOI";
        }
        if (diem >= 6.5) {
            return "KHA";
        }
        if (diem >= 5.0) {
            return "TRUNG BINH";
        }
        return "KEM";
    }

    double getTongKet() {
        return tongKet;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", ma, ten, tongKet, xepLoai);
    }
}

public class XepLoaiSinhVien {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<SinhVienXL> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            int luyenTap = Integer.parseInt(sc.nextLine().trim());
            int thucHanh = Integer.parseInt(sc.nextLine().trim());
            int thi = Integer.parseInt(sc.nextLine().trim());
            ds.add(new SinhVienXL(i, ten, luyenTap, thucHanh, thi));
        }
        Collections.sort(ds, Comparator.comparingDouble(SinhVienXL::getTongKet).reversed());
        StringBuilder sb = new StringBuilder();
        for (SinhVienXL sv : ds) {
            sb.append(sv.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
