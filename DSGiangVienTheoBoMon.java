import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GiangVien {
    private String maGV;
    private String hoTen;
    private String boMon;
    private String boMonVietTat;

    public GiangVien(int id, String hoTen, String boMon) {
        this.maGV = String.format("GV%02d", id);
        this.hoTen = hoTen;
        this.boMon = boMon;
        this.boMonVietTat = DSGiangVienTheoBoMon.taoVietTat(boMon);
    }

    public String getBoMon() {
        return this.boMon;
    }

    @Override
    public String toString() {
        return this.maGV + " " + this.hoTen + " " + this.boMonVietTat;
    }
}

public class DSGiangVienTheoBoMon {
    
    public static String taoVietTat(String s) {
        StringBuilder vietTat = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (String word : words) {
            vietTat.append(word.substring(0, 1).toUpperCase());
        }
        return vietTat.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        List<GiangVien> dsGiangVien = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String bm = sc.nextLine();
            dsGiangVien.add(new GiangVien(i, ten, bm));
        }

        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String queryBoMon = sc.nextLine();
            String queryVietTat = taoVietTat(queryBoMon);
            
            System.out.println("DANH SACH GIANG VIEN BO MON " + queryVietTat + ":");
            
            for (GiangVien gv : dsGiangVien) {
                if (gv.getBoMon().equals(queryBoMon)) {
                    System.out.println(gv);
                }
            }
        }
        sc.close();
    }
}