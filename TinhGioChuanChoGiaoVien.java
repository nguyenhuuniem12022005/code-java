import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Lop nay chi dung de luu tru thong tin thuan tuy cua mot lop hoc phan
 * de dam bao giu dung thu tu nhap vao.
 */
class LopHocPhan {
    String maGV;
    String maMon;
    double gio;

    public LopHocPhan(String maGV, String maMon, double gio) {
        this.maGV = maGV;
        this.maMon = maMon;
        this.gio = gio;
    }
}

public class TinhGioChuanChoGiaoVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Doc Mon hoc -> Luu vao Map de tra cuu Ten Mon tu Ma Mon
        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> monHocMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2); // Split chi lay 2 phan: [Ma] va [Ten]
            monHocMap.put(parts[0], parts[1]);
        }

        // 2. Doc Giang Vien -> Luu vao Map de tra cuu Ten GV tu Ma GV
        int m = Integer.parseInt(sc.nextLine());
        Map<String, String> giangVienMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            giangVienMap.put(parts[0], parts[1]);
        }

        // 3. Doc Lop Hoc Phan -> Luu vao ArrayList de giu dung thu tu nhap
        int k = Integer.parseInt(sc.nextLine());
        ArrayList<LopHocPhan> dsLopHocPhan = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] parts = sc.nextLine().split(" ");
            String maGV = parts[0];
            String maMon = parts[1];
            double gio = Double.parseDouble(parts[2]);
            dsLopHocPhan.add(new LopHocPhan(maGV, maMon, gio));
        }

        // 4. Doc Ma GV can truy van
        String queryMaGV = sc.nextLine();

        // 5. Xu ly va In ket qua
        // Lay ten giang vien tu Map
        String tenGV = giangVienMap.get(queryMaGV);
        System.out.println("Giang vien: " + tenGV);

        double tongGio = 0.0;

        // Duyet qua ArrayList (de dam bao dung thu tu)
        for (LopHocPhan lop : dsLopHocPhan) {
            // Neu lop hoc phan nay la cua giang vien can tim
            if (lop.maGV.equals(queryMaGV)) {
                // Tra cuu ten mon hoc tu Map mon hoc
                String tenMon = monHocMap.get(lop.maMon);
                
                // In ra ten mon va gio
                System.out.println(tenMon + " " + lop.gio);
                
                // Cong don vao tong gio
                tongGio += lop.gio;
            }
        }

        System.out.printf("Tong: %.2f\n", tongGio);

        sc.close();
    }
}