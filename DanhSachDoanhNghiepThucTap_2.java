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
    
    public int getSoLuongSV() {
        return this.soLuongSV;
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

public class DanhSachDoanhNghiepThucTap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<DoanhNghiep> danhSachGoc = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            danhSachGoc.add(new DoanhNghiep(ma, ten, soLuong));
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", a, b);

            List<DoanhNghiep> danhSachLoc = new ArrayList<>();
            for (DoanhNghiep dn : danhSachGoc) {
                if (dn.getSoLuongSV() >= a && dn.getSoLuongSV() <= b) {
                    danhSachLoc.add(dn);
                }
            }
            
            Collections.sort(danhSachLoc);

            for (DoanhNghiep dn : danhSachLoc) {
                System.out.println(dn);
            }
        }
        sc.close();
    }
}