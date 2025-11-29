import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ThiSinh {
    private static final DecimalFormat ONE_DECIMAL = new DecimalFormat("0.#");
    private final String ma;
    private final String hoTen;
    private final double uuTien;
    private final double diemXet;

    ThiSinh(String ma, String hoTen, double toan, double ly, double hoa) {
        this.ma = ma.trim();
        this.hoTen = chuanHoaTen(hoTen);
        this.uuTien = tinhUuTien(this.ma.substring(0, 3));
        this.diemXet = toan * 2 + ly + hoa + this.uuTien;
    }

    private double tinhUuTien(String khuVuc) {
        switch (khuVuc) {
            case "KV1":
                return 0.5;
            case "KV2":
                return 1.0;
            case "KV3":
                return 2.5;
            default:
                return 0.0;
        }
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

    double getDiemXet() {
        return diemXet;
    }

    String getMa() {
        return ma;
    }

    private String formatScore(double value) {
        if (Math.abs(value - Math.round(value)) < 1e-9) {
            return String.valueOf((long) Math.round(value));
        }
        return ONE_DECIMAL.format(value);
    }

    String toOutput(double diemChuan) {
        String trangThai = diemXet + 1e-9 >= diemChuan ? "TRUNG TUYEN" : "TRUOT";
        return ma + " " + hoTen + " " + formatScore(uuTien) + " " + formatScore(diemXet) + " " + trangThai;
    }
}

public class XetTuyenSinh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<ThiSinh> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine().trim());
            double ly = Double.parseDouble(sc.nextLine().trim());
            double hoa = Double.parseDouble(sc.nextLine().trim());
            ds.add(new ThiSinh(ma, ten, toan, ly, hoa));
        }
        int chiTieu = Integer.parseInt(sc.nextLine().trim());

        Collections.sort(ds, Comparator.comparingDouble(ThiSinh::getDiemXet).reversed().thenComparing(ThiSinh::getMa));
        double diemChuan = ds.get(Math.min(chiTieu, ds.size()) - 1).getDiemXet();

        System.out.println(String.format("%.1f", diemChuan));
        StringBuilder sb = new StringBuilder();
        for (ThiSinh ts : ds) {
            sb.append(ts.toOutput(diemChuan)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
