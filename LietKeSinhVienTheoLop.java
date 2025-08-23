import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;
    private String email;

    public SinhVien(String maSV, String hoTen, String lop, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }
    
    public String getLop() {
        return this.lop;
    }

    @Override
    public String toString() {
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

public class LietKeSinhVienTheoLop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            danhSach.add(new SinhVien(ma, ten, lop, email));
        }

        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String lopCanTim = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + lopCanTim + ":");

            for (SinhVien sv : danhSach) {
                if (sv.getLop().equals(lopCanTim)) {
                    System.out.println(sv);
                }
            }
        }
        
        sc.close();
    }
}