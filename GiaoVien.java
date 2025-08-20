import java.util.Scanner;
public class GiaoVien {
    private String maNgach;
    private String hoTen;
    private long luongCoBan;
    private int heSoBacLuong;
    private long phuCap;
    private long thuNhap;
    public GiaoVien(String maNgach, String hoTen, long luongCoBan) {
        this.maNgach = maNgach;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
        String chucVu = maNgach.substring(0, 2);
        this.heSoBacLuong = Integer.parseInt(maNgach.substring(2));
        if (chucVu.equals("HT")) {
            this.phuCap = 2000000;
        } else if (chucVu.equals("HP")) {
            this.phuCap = 900000;
        } else { 
            this.phuCap = 500000;
        }

        this.thuNhap = this.luongCoBan * this.heSoBacLuong + this.phuCap;
    }
    public String toString() {
        return this.maNgach + " " +
               this.hoTen + " " +
               this.heSoBacLuong + " " +
               this.phuCap + " " +
               this.thuNhap;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maNgach = sc.nextLine();
        String hoTen = sc.nextLine();
        long luongCoBan = sc.nextLong();
        GiaoVien gv = new GiaoVien(maNgach, hoTen, luongCoBan);
        System.out.println(gv);

        sc.close();
    }
}
