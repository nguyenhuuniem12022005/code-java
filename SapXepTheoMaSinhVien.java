import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
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

    @Override
    public int compareTo(SinhVien other) {
        return this.maSV.compareTo(other.maSV);
    }

    @Override
    public String toString() {
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

public class SapXepTheoMaSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SinhVien> danhSach = new ArrayList<>();
            while (sc.hasNextLine()) {
            String ma = sc.nextLine();
            if (ma.isEmpty()) {
                break;
            }
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            danhSach.add(new SinhVien(ma, ten, lop, email));
        }

        Collections.sort(danhSach);
        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
        
        sc.close();
    }
}