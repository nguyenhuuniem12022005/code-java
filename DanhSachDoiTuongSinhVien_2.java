import java.util.*;
class SinhVien{
    private String ma;
    private String ten;
    private String lop;
    private String ngaysinh;
    private double gpa;
    public SinhVien() {
        this.ma = "";
        this.ten = "";
        this.lop = "";
        this.ngaysinh = "";
        this.gpa = 0.0;
    }

    public SinhVien(int stt, String ten, String lop, String ngaysinh, double gpa) {
        this.ma = String.format("B20DCCN%03d", stt);
        this.ten = chuanHoaHoTen(ten);
        this.lop = lop;
        this.ngaysinh = chuanHoaNgaySinh(ngaysinh);
        this.gpa = gpa;
    }

    private String chuanHoaNgaySinh(String ngaysinh) {
        StringBuilder sb = new StringBuilder();
        String[] parts = ngaysinh.split("/");

        if (parts[0].length() == 1) {
            sb.append("0");
        }
        sb.append(parts[0]).append("/");

        if (parts[1].length() == 1) {
            sb.append("0");
        }
        sb.append(parts[1]).append("/");
        
        sb.append(parts[2]);

        return sb.toString();
    }
    private String chuanHoaHoTen(String ten) {
        ten = ten.trim().toLowerCase();
        String[] words = ten.split("\\s+");
        StringBuilder standardizedName = new StringBuilder();
        for (String word : words) {
            standardizedName.append(Character.toUpperCase(word.charAt(0)));
            standardizedName.append(word.substring(1));
            standardizedName.append(" ");
        }
        return standardizedName.toString().trim();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", ma, ten, lop, ngaysinh, gpa);
    }
}
public class DanhSachDoiTuongSinhVien_2 {
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

        for (SinhVien sv : danhSachSV) {
            System.out.println(sv);
        }
        
        scanner.close();
    }
}
