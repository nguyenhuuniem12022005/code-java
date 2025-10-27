import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class LopHocPhan {
    private String maGV;
    private String maMon;
    private double gioChuan;

    public LopHocPhan(String maGV, String maMon, double gioChuan) {
        this.maGV = maGV;
        this.maMon = maMon;
        this.gioChuan = gioChuan;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getMaMon() {
        return maMon;
    }

    public double getGioChuan() {
        return gioChuan;
    }
}

public class LapBangTinhToanGioChuanGV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> monHocMap = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String maMon = sc.next();
            String tenMon = sc.nextLine().trim();
            monHocMap.put(maMon, tenMon);
        }

        Map<String, String> giangVienMap = new HashMap<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String maGV = sc.next();
            String tenGV = sc.nextLine().trim();
            giangVienMap.put(maGV, tenGV);
        }

        List<LopHocPhan> dsLopHocPhan = new ArrayList<>();
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String maGV = sc.next();
            String maMon = sc.next();
            double gio = sc.nextDouble();
            dsLopHocPhan.add(new LopHocPhan(maGV, maMon, gio));
        }

        String maGVQuery = sc.next();
        sc.close();

        System.out.println("Giang vien: " + giangVienMap.get(maGVQuery));

        double tongGio = 0.0;
        for (LopHocPhan lhp : dsLopHocPhan) {
            if (lhp.getMaGV().equals(maGVQuery)) {
                String tenMon = monHocMap.get(lhp.getMaMon());
                System.out.println(tenMon + " " + lhp.getGioChuan());
                tongGio += lhp.getGioChuan();
            }
        }

        System.out.printf("Tong: %.2f\n", tongGio);
    }
}