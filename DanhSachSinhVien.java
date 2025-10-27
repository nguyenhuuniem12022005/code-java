package danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Lớp SinhVien (không public) để có thể gộp chung file với lớp Main
class SinhVien implements Serializable {
    private String ma;
    private String ten;
    private String lop;
    private Date ngaysinh;
    private float gpa;

    // Định dạng ngày tháng
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public SinhVien(int id, String ten, String lop, String ngaysinhStr, float gpa) {
        this.ma = String.format("B20DCCN%03d", id);
        this.ten = ten;
        this.lop = lop;
        this.gpa = gpa;

        try {
            // Chuẩn hóa chuỗi ngày sinh về dạng dd/MM/yyyy rồi parse
            this.ngaysinh = sdf.parse(chuanHoaNgay(ngaysinhStr));
        } catch (ParseException e) {
            // Trong bối cảnh bài tập, giả sử đầu vào ngày sinh luôn hợp lệ
            // sau khi chuẩn hóa.
            this.ngaysinh = new Date(); 
        }
    }

    private String chuanHoaNgay(String s) {
        String[] parts = s.split("/");
        if (parts[0].length() == 1) {
            parts[0] = "0" + parts[0];
        }
        if (parts[1].length() == 1) {
            parts[1] = "0" + parts[1];
        }
        return parts[0] + "/" + parts[1] + "/" + parts[2];
    }

    @Override
    public String toString() {
        String ngaySinhFormatted = sdf.format(this.ngaysinh);
        return this.ma + " " + this.ten + " " + this.lop + " " 
               + ngaySinhFormatted + " " + String.format("%.2f", this.gpa);
    }
}

// Lớp Main public chứa hàm main
public class DanhSachSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Khởi tạo luồng đọc file nhị phân
        FileInputStream fis = new FileInputStream("SV.in");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Đọc đối tượng ArrayList từ file
        ArrayList<SinhVien> ds = (ArrayList<SinhVien>) ois.readObject();

        // Duyệt qua danh sách và in ra màn hình
        for (SinhVien sv : ds) {
            System.out.println(sv);
        }

        // Đóng luồng
        ois.close();
        fis.close();
    }
}