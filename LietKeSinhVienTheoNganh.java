import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;
    private String email;

    public SinhVien(String maSV, String hoTen, String lop, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
    }

    public String getMaSV() { return maSV; }
    public String getLop() { return lop; }

    @Override
    public String toString() {
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + this.email;
    }
}

public class LietKeSinhVienTheoNganh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            danhSach.add(new SinhVien(ma, ten, lop, email));
        }

        Map<String, String> nganhMap = new HashMap<>();
        nganhMap.put("Ke toan", "DCKT");
        nganhMap.put("Cong nghe thong tin", "DCCN");
        nganhMap.put("An toan thong tin", "DCAT");
        nganhMap.put("Vien thong", "DCVT");
        nganhMap.put("Dien tu", "DCDT");
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String tenNganhQuery = sc.nextLine();
            String maNganh = nganhMap.get(tenNganhQuery);

            System.out.println("DANH SACH SINH VIEN NGANH " + tenNganhQuery.toUpperCase() + ":");

            for (SinhVien sv : danhSach) {
                if (maNganh.equals("DCCN") || maNganh.equals("DCAT")) {
                    if (sv.getMaSV().contains(maNganh) && !sv.getLop().startsWith("E")) {
                        System.out.println(sv);
                    }
                } 
                else {
                    if (sv.getMaSV().contains(maNganh)) {
                        System.out.println(sv);
                    }
                }
            }
        }
        sc.close();
    }
}