import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class CaThi {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final String ma;
    private final String ngay;
    private final String gio;
    private final String phong;
    private final LocalDateTime thoiGian;

    CaThi(int idx, String ngay, String gio, String phong) {
        this.ma = String.format("C%03d", idx);
        this.ngay = ngay.trim();
        this.gio = gio.trim();
        this.phong = phong.trim();
        this.thoiGian = LocalDateTime.parse(this.ngay + " " + this.gio, FORMAT);
    }

    LocalDateTime getThoiGian() {
        return thoiGian;
    }

    String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ngay + " " + gio + " " + phong;
    }
}

public class DanhSachCaThi {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<CaThi> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ngay = sc.nextLine();
            String gio = sc.nextLine();
            String phong = sc.nextLine();
            ds.add(new CaThi(i, ngay, gio, phong));
        }
        Collections.sort(ds, Comparator.comparing(CaThi::getThoiGian).thenComparing(CaThi::getMa));
        StringBuilder sb = new StringBuilder();
        for (CaThi c : ds) {
            sb.append(c.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
