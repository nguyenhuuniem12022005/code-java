import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class GiangVien {
    private String maGV;
    private String tenGV;
    private double tongGio;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGio = 0.0;
    }

    public void addGio(double gio) {
        this.tongGio += gio;
    }

    public String getMaGV() {
        return maGV;
    }

    @Override
    public String toString() {
        return this.tenGV + " " + String.format("%.2f", this.tongGio);
    }
}

public class DanhSachGiangVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            sc.nextLine();
        }

        int m = Integer.parseInt(sc.nextLine());
        List<GiangVien> dsGiangVien = new ArrayList<>();
        Map<String, GiangVien> mapGV = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String ma = sc.next();
            String ten = sc.nextLine().trim();
            GiangVien gv = new GiangVien(ma, ten);
            dsGiangVien.add(gv);
            mapGV.put(ma, gv);
        }

        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String maGV = sc.next();
            String maMon = sc.next();
            double gio = sc.nextDouble();

            GiangVien gv = mapGV.get(maGV);
            if (gv != null) {
                gv.addGio(gio);
            }
        }

        sc.close();

        for (GiangVien gv : dsGiangVien) {
            System.out.println(gv);
        }
    }
}