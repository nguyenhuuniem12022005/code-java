import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class KhachHang {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy");
    private final String id;
    private final String name;
    private final String room;
    private final long daysStayed;
    private final long total;

    KhachHang(int index, String rawName, String room, String checkIn, String checkOut, long service) {
        this.id = String.format("KH%02d", index);
        this.name = normalizeName(rawName);
        this.room = room.trim();
        LocalDate start = LocalDate.parse(checkIn.trim(), DATE_FORMAT);
        LocalDate end = LocalDate.parse(checkOut.trim(), DATE_FORMAT);
        this.daysStayed = ChronoUnit.DAYS.between(start, end) + 1;
        long dailyPrice = pricePerDay(this.room.charAt(0));
        this.total = dailyPrice * this.daysStayed + service;
    }

    private long pricePerDay(char floorChar) {
        switch (floorChar) {
            case '1':
                return 25;
            case '2':
                return 34;
            case '3':
                return 50;
            case '4':
                return 80;
            default:
                return 0;
        }
    }

    private String normalizeName(String raw) {
        String[] parts = raw.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0)));
                if (p.length() > 1) {
                    sb.append(p.substring(1));
                }
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + room + " " + daysStayed + " " + total;
    }
}

public class TinhTienPhong {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<KhachHang> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String name = sc.nextLine();
            String room = sc.nextLine();
            String checkIn = sc.nextLine();
            String checkOut = sc.nextLine();
            long service = Long.parseLong(sc.nextLine().trim());
            list.add(new KhachHang(i, name, room, checkIn, checkOut, service));
        }
        Collections.sort(list, Comparator.comparingLong(KhachHang::getTotal).reversed());
        StringBuilder out = new StringBuilder();
        for (KhachHang kh : list) {
            out.append(kh.toString()).append("\n");
        }
        System.out.print(out.toString());
    }
}
