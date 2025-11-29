import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private final String ma;
    private final String ten;
    private final int chiTieu;

    DoanhNghiep(String ma, String ten, int chiTieu) {
        this.ma = ma;
        this.ten = ten;
        this.chiTieu = chiTieu;
    }

    @Override
    public int compareTo(DoanhNghiep other) {
        return this.ma.compareTo(other.ma);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + chiTieu;
    }
}

public class DanhSachDoanhNghiep {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<DoanhNghiep> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int chiTieu = Integer.parseInt(sc.nextLine().trim());
            ds.add(new DoanhNghiep(ma, ten, chiTieu));
        }
        Collections.sort(ds);
        StringBuilder sb = new StringBuilder();
        for (DoanhNghiep dn : ds) {
            sb.append(dn.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
