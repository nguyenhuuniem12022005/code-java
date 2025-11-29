import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class HoTen {
    private final String full;
    private final String[] parts;
    private final char[] initials;

    HoTen(String full) {
        this.full = full.trim();
        this.parts = this.full.split("\\s+");
        this.initials = new char[parts.length];
        for (int i = 0; i < parts.length; i++) {
            initials[i] = Character.toUpperCase(parts[i].charAt(0));
        }
    }

    boolean khopVietTat(String vt) {
        String[] tokens = vt.split("\\.");
        if (tokens.length != initials.length) {
            return false;
        }
        boolean wildcardUsed = false;
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("*")) {
                if (wildcardUsed) {
                    return false;
                }
                wildcardUsed = true;
                continue;
            }
            if (t.length() != 1) {
                return false;
            }
            if (Character.toUpperCase(t.charAt(0)) != initials[i]) {
                return false;
            }
        }
        return true;
    }

    String getFull() {
        return full;
    }

    String getTen() {
        return parts[parts.length - 1];
    }

    String getHo() {
        return parts[0];
    }
}

public class TenVietTat {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int n = Integer.parseInt(sc.nextLine().trim().replace("\uFEFF", ""));
        List<HoTen> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            danhSach.add(new HoTen(sc.nextLine()));
        }
        int m = Integer.parseInt(sc.nextLine().trim());
        List<String> vietTatList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            vietTatList.add(sc.nextLine().trim());
        }

        Comparator<HoTen> comp = Comparator.comparing(HoTen::getTen, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(HoTen::getHo, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(HoTen::getFull, String.CASE_INSENSITIVE_ORDER);

        StringBuilder out = new StringBuilder();
        for (String vt : vietTatList) {
            List<HoTen> matched = new ArrayList<>();
            for (HoTen ht : danhSach) {
                if (ht.khopVietTat(vt)) {
                    matched.add(ht);
                }
            }
            matched.sort(comp);
            for (HoTen ht : matched) {
                out.append(ht.getFull()).append("\n");
            }
        }
        System.out.print(out.toString());
    }
}
