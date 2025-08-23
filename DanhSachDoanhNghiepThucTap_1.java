import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private String maDN;
    private String tenDN;
    private int soLuongSV;

    public DoanhNghiep(String maDN, String tenDN, int soLuongSV) {
        this.maDN = maDN;
        this.tenDN = tenDN;
        this.soLuongSV = soLuongSV;
    }

    @Override
    public int compareTo(DoanhNghiep other) {
        if (this.soLuongSV != other.soLuongSV) {
            return Integer.compare(other.soLuongSV, this.soLuongSV);
        }
        
        return this.maDN.compareTo(other.maDN);
    }

    @Override
    public String toString() {
        return this.maDN + " " + this.tenDN + " " + this.soLuongSV;
    }
}

public class DanhSachDoanhNghiepThucTap_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<DoanhNghiep> danhSach = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            danhSach.add(new DoanhNghiep(ma, ten, soLuong));
        }

        Collections.sort(danhSach);

        for (DoanhNghiep dn : danhSach) {
            System.out.println(dn);
        }
        
        sc.close();
    }
}