import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class ThiSinhTuyenSinh {
    private static final DecimalFormat ONE_DECIMAL = new DecimalFormat("0.0",
            DecimalFormatSymbols.getInstance(Locale.US));
    private final String ma;
    private final String hoTen;
    private final double tongDiem;

    ThiSinhTuyenSinh(int idx, String hoTen, double diemThi, String danToc, String khuVuc) {
        this.ma = String.format("TS%02d", idx);
        this.hoTen = chuanHoaTen(hoTen);
        double uuTien = tinhUuTienDanToc(danToc) + tinhUuTienKhuVuc(khuVuc);
        this.tongDiem = diemThi + uuTien;
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

    private double tinhUuTienDanToc(String danToc) {
        return danToc.trim().equalsIgnoreCase("Kinh") ? 0.0 : 1.5;
    }

    private double tinhUuTienKhuVuc(String khuVuc) {
        String kv = khuVuc.trim();
        if (kv.equals("1")) return 1.5;
        if (kv.equals("2")) return 1.0;
        return 0.0;
    }

    double getTongDiem() {
        return tongDiem;
    }

    String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        String trangThai = tongDiem >= 20.5 ? "Do" : "Truot";
        return String.format("%s %s %s %s", ma, hoTen, ONE_DECIMAL.format(tongDiem), trangThai);
    }
}

public class DiemTuyenSinh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<ThiSinhTuyenSinh> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            double diemThi = Double.parseDouble(sc.nextLine().trim());
            String danToc = sc.nextLine();
            String khuVuc = sc.nextLine();
            list.add(new ThiSinhTuyenSinh(i, ten, diemThi, danToc, khuVuc));
        }
        Collections.sort(list, Comparator.comparingDouble(ThiSinhTuyenSinh::getTongDiem).reversed().thenComparing(ThiSinhTuyenSinh::getMa));
        StringBuilder sb = new StringBuilder();
        for (ThiSinhTuyenSinh ts : list) {
            sb.append(ts.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
