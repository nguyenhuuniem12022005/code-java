import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GiangVien {
    String maGV;
    String tenGV;
    double tongGioChuan;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGioChuan = 0.0;
    }

    public void addGioChuan(double gio) {
        this.tongGioChuan += gio;
    }

    public String getMaGV() {
        return maGV;
    }

    @Override
    public String toString() {
        // Dinh dang san dau ra theo yeu cau: Ten + Tong gio (2 so thap phan)
        return tenGV + " " + String.format("%.2f", tongGioChuan);
    }
}

public class BangTinhGioChuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            sc.nextLine(); 
        }


        int m = Integer.parseInt(sc.nextLine());
        
        // Dung ArrayList de dam bao dung thu tu nhap vao khi in ra
        ArrayList<GiangVien> dsGiangVien = new ArrayList<>();
        
        // Dung HashMap de tra cuu giang vien nhanh bang MaGV khi doc lop hoc phan
        Map<String, GiangVien> gvMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            // Split theo khoang trong, gioi han la 2 phan: [MaGV] va [TenGV]
            // "GV01 Nguyen Van An" -> parts[0]="GV01", parts[1]="Nguyen Van An"
            String[] parts = line.split(" ", 2);
            String ma = parts[0];
            String ten = parts[1];
            
            GiangVien gv = new GiangVien(ma, ten);
            
            dsGiangVien.add(gv); 
            gvMap.put(ma, gv);   
        }


        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            String maGV = parts[0];

            double gio = Double.parseDouble(parts[2]);


            GiangVien gv = gvMap.get(maGV);
            gv.addGioChuan(gio);
        }


        for (GiangVien gv : dsGiangVien) {
            System.out.println(gv); 
        }

        sc.close();
    }
}