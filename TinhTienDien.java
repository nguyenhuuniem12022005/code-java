import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class KhachDien {
    private final String ma;
    private final String ten;
    private final long trongDinhMuc;
    private final long vuotDinhMuc;
    private final long vat;
    private final long tong;

    KhachDien(int idx, String tenRaw, String loai, long chiSoDau, long chiSoCuoi) {
        this.ma = String.format("KH%02d", idx);
        this.ten = chuanHoaTen(tenRaw);
        long soDien = chiSoCuoi - chiSoDau;
        long dinhMuc = layDinhMuc(loai);
        this.trongDinhMuc = Math.min(soDien, dinhMuc) * 450;
        this.vuotDinhMuc = Math.max(0, soDien - dinhMuc) * 1000;
        this.vat = Math.round(this.vuotDinhMuc * 0.05);
        this.tong = this.trongDinhMuc + this.vuotDinhMuc + this.vat;
    }

    private long layDinhMuc(String loai) {
        switch (loai.trim()) {
            case "A":
                return 100;
            case "B":
                return 500;
            case "C":
                return 200;
            default:
                return 0;
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

    long getTong() {
        return tong;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + trongDinhMuc + " " + vuotDinhMuc + " " + vat + " " + tong;
    }
}

public class TinhTienDien {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<KhachDien> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String[] line = sc.nextLine().trim().split("\\s+");
            String loai = line[0];
            long dau = Long.parseLong(line[1]);
            long cuoi = Long.parseLong(line[2]);
            list.add(new KhachDien(i, ten, loai, dau, cuoi));
        }
        Collections.sort(list, Comparator.comparingLong(KhachDien::getTong).reversed());
        StringBuilder sb = new StringBuilder();
        for (KhachDien kh : list) {
            sb.append(kh.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
