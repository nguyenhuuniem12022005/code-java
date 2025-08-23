import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String ten;
    private int baiDung;
    private int luotNop;

    public SinhVien(String ten, int baiDung, int luotNop) {
        this.ten = ten;
        this.baiDung = baiDung;
        this.luotNop = luotNop;
    }

    @Override
    public int compareTo(SinhVien other) {
        if (this.baiDung != other.baiDung) {
            return Integer.compare(other.baiDung, this.baiDung);
        }
        
        if (this.luotNop != other.luotNop) {
            return Integer.compare(this.luotNop, other.luotNop);
        }
        
        return this.ten.compareTo(other.ten);
    }

    @Override
    public String toString() {
        return this.ten + " " + this.baiDung + " " + this.luotNop;
    }
}

public class BangXepHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<SinhVien> danhSach = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            int c = sc.nextInt();
            int t = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            danhSach.add(new SinhVien(ten, c, t));
        }

        Collections.sort(danhSach);

        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
        
        sc.close();
    }
}