import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String maSV;
    private String hoTen;
    private String lop;
    private double diem1, diem2, diem3;

    public SinhVien(String maSV, String hoTen, String lop, double diem1, double diem2, double diem3) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    @Override
    public int compareTo(SinhVien other) {
        // So sánh theo mã sinh viên để sắp xếp tăng dần
        return this.maSV.compareTo(other.maSV);
    }

    public String getFormattedString(int stt) {
        return String.format("%d %s %s %s %.1f %.1f %.1f",
                stt, this.maSV, this.hoTen, this.lop, this.diem1, this.diem2, this.diem3);
    }
}

public class BangDiemThanhPhan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<SinhVien> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());
            danhSach.add(new SinhVien(ma, ten, lop, d1, d2, d3));
        }

        // Sắp xếp danh sách
        Collections.sort(danhSach);

        // In kết quả
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i).getFormattedString(i + 1));
        }
        
        sc.close();
    }
}