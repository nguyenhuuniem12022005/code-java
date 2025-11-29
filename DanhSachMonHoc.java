import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MonHoc implements Comparable<MonHoc> {
    private final String ma;
    private final String ten;
    private final int tinChi;

    MonHoc(String ma, String ten, int tinChi) {
        this.ma = ma;
        this.ten = ten;
        this.tinChi = tinChi;
    }

    @Override
    public int compareTo(MonHoc other) {
        return this.ten.compareTo(other.ten);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + tinChi;
    }
}

public class DanhSachMonHoc {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<MonHoc> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int tinChi = Integer.parseInt(sc.nextLine().trim());
            list.add(new MonHoc(ma, ten, tinChi));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (MonHoc mh : list) {
            sb.append(mh.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
