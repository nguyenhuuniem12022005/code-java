import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class HocSinh {
    private String maHS;
    private String hoTen;
    private double diemTB;
    private String xepLoai;
    private int xepHang;

    public HocSinh(String maHS, String hoTen, double diemTB) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.xepLoai = tinhXepLoai();
    }

    private String tinhXepLoai() {
        if (this.diemTB < 5) return "Yeu";
        if (this.diemTB < 7) return "Trung Binh";
        if (this.diemTB < 9) return "Kha";
        return "Gioi";
    }

    public double getDiemTB() { return diemTB; }
    public int getXepHang() { return xepHang; }
    public void setXepHang(int xepHang) { this.xepHang = xepHang; }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s %d", maHS, hoTen, diemTB, xepLoai, xepHang);
    }
}

public class XepHangHocSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<HocSinh> danhSachGoc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            double dtb = Double.parseDouble(sc.nextLine());
            String ma = String.format("HS%02d", i + 1);
            danhSachGoc.add(new HocSinh(ma, ten, dtb));
        }

        List<HocSinh> danhSachSapXep = new ArrayList<>(danhSachGoc);
        danhSachSapXep.sort(Comparator.comparingDouble(HocSinh::getDiemTB).reversed());

        if (!danhSachSapXep.isEmpty()) {
            danhSachSapXep.get(0).setXepHang(1);
            for (int i = 1; i < danhSachSapXep.size(); i++) {
                HocSinh hienTai = danhSachSapXep.get(i);
                HocSinh truocDo = danhSachSapXep.get(i - 1);

                if (hienTai.getDiemTB() == truocDo.getDiemTB()) {
                    hienTai.setXepHang(truocDo.getXepHang());
                } else {
                    hienTai.setXepHang(i + 1);
                }
            }
        }

        for (HocSinh hs : danhSachGoc) {
            System.out.println(hs);
        }

        sc.close();
    }
}