import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String maSV;
    private String hoTen;
    private double diemTB;
    private int hang;
    private int id; // Dùng để sắp xếp theo mã SV (thứ tự nhập) nếu điểm bằng nhau

    public SinhVien(int id, String hoTen, int diem1, int diem2, int diem3) {
        this.id = id;
        this.maSV = String.format("SV%02d", id);
        this.hoTen = chuanHoaTen(hoTen);
        
        // Tổng số tín chỉ = 3 + 3 + 2 = 8
        this.diemTB = (diem1 * 3.0 + diem2 * 3.0 + diem3 * 2.0) / 8.0;
        this.hang = 0; // Sẽ được gán sau
    }

    private String chuanHoaTen(String s) {
        String[] words = s.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public double getDiemTB() {
        return this.diemTB;
    }

    public int getHang() {
        return this.hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    @Override
    public int compareTo(SinhVien other) {
        // Sắp xếp điểm trung bình giảm dần
        if (this.diemTB != other.diemTB) {
            return Double.compare(other.diemTB, this.diemTB);
        }
        // Nếu điểm TB bằng nhau, sắp xếp theo mã sinh viên (id) tăng dần
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return this.maSV + " " + this.hoTen + " " + String.format("%.2f", this.diemTB) + " " + this.hang;
    }
}

public class TinhDiemTrungBinh {
    public static void main(String[] args) throws FileNotFoundException {
        // Đọc từ file BANGDIEM.in
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        
        List<SinhVien> dsSV = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            int d1 = Integer.parseInt(sc.nextLine());
            int d2 = Integer.parseInt(sc.nextLine());
            int d3 = Integer.parseInt(sc.nextLine());
            dsSV.add(new SinhVien(i, ten, d1, d2, d3));
        }
        sc.close();

        // Sắp xếp danh sách
        Collections.sort(dsSV);

        // Xử lý xếp hạng
        if (!dsSV.isEmpty()) {
            dsSV.get(0).setHang(1); // Hạng 1 cho người đầu tiên
            
            for (int i = 1; i < dsSV.size(); i++) {
                SinhVien svHienTai = dsSV.get(i);
                SinhVien svTruoc = dsSV.get(i - 1);

                // So sánh điểm đã làm tròn (hoặc dùng epsilon, nhưng trong trường hợp này so sánh trực tiếp 
                // sau khi tính toán là đủ vì chúng được tính toán theo cùng một cách)
                // Để an toàn hơn khi so sánh double, ta nên so sánh string đã format
                 String dtb1 = String.format("%.2f", svHienTai.getDiemTB());
                 String dtb2 = String.format("%.2f", svTruoc.getDiemTB());

                if (dtb1.equals(dtb2)) {
                // if (svHienTai.getDiemTB() == svTruoc.getDiemTB()) { // So sánh trực tiếp có thể rủi ro
                    svHienTai.setHang(svTruoc.getHang());
                } else {
                    // Xếp hạng bằng vị trí (index + 1)
                    svHienTai.setHang(i + 1);
                }
            }
        }

        // In kết quả
        for (SinhVien sv : dsSV) {
            System.out.println(sv);
        }
    }
}