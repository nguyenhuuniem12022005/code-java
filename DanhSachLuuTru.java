import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Khach {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final String ma;
    private final String hoTen;
    private final String maPhong;
    private final long soNgay;

    Khach(int idx, String hoTen, String maPhong, String den, String di) {
        this.ma = String.format("KH%02d", idx);
        this.hoTen = hoTen.trim();
        this.maPhong = maPhong.trim();
        LocalDate start = LocalDate.parse(den.trim(), DATE_FORMAT);
        LocalDate end = LocalDate.parse(di.trim(), DATE_FORMAT);
        this.soNgay = ChronoUnit.DAYS.between(start, end);
    }

    long getSoNgay() {
        return soNgay;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + maPhong + " " + soNgay;
    }
}

public class DanhSachLuuTru {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<Khach> ds = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String hoTen = sc.nextLine();
            String maPhong = sc.nextLine();
            String den = sc.nextLine();
            String di = sc.nextLine();
            ds.add(new Khach(i, hoTen, maPhong, den, di));
        }
        Collections.sort(ds, Comparator.comparingLong(Khach::getSoNgay).reversed());
        StringBuilder sb = new StringBuilder();
        for (Khach k : ds) {
            sb.append(k.toString()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
