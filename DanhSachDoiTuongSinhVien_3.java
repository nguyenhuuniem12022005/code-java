import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String maSV;
    private String hoTen;
    private String lop;
    private String ngaySinh;
    private double gpa;

    public SinhVien(int stt, String hoTen, String lop, String ngaySinh, double gpa) {
        this.maSV = String.format("B20DCCN%03d", stt);
        this.hoTen = chuanHoaHoTen(hoTen);
        this.lop = lop;
        this.ngaySinh = chuanHoaNgaySinh(ngaySinh);
        this.gpa = gpa;
    }
    
    public double getGpa() {
        return gpa;
    }

    private String chuanHoaHoTen(String hoTen) {
        hoTen = hoTen.trim().toLowerCase();
        String[] words = hoTen.split("\\s+");
        StringBuilder standardizedName = new StringBuilder();
        for (String word : words) {
            standardizedName.append(Character.toUpperCase(word.charAt(0)));
            standardizedName.append(word.substring(1));
            standardizedName.append(" ");
        }
        return standardizedName.toString().trim();
    }

    private String chuanHoaNgaySinh(String ngaySinh) {
        String[] parts = ngaySinh.split("/");
        StringBuilder sb = new StringBuilder();
        
        if (parts[0].length() == 1) sb.append("0");
        sb.append(parts[0]).append("/");
        
        if (parts[1].length() == 1) sb.append("0");
        sb.append(parts[1]).append("/");
        
        sb.append(parts[2]);

        return sb.toString();
    }

    @Override
    public int compareTo(SinhVien other) {
        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", maSV, hoTen, lop, ngaySinh, gpa);
    }
}

public class DanhSachDoiTuongSinhVien_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<SinhVien> danhSachSV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String hoTen = scanner.nextLine();
            String lop = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            double gpa = Double.parseDouble(scanner.nextLine());
            danhSachSV.add(new SinhVien(i + 1, hoTen, lop, ngaySinh, gpa));
        }

        Collections.sort(danhSachSV);

        for (SinhVien sv : danhSachSV) {
            System.out.println(sv);
        }
        
        scanner.close();
    }
}