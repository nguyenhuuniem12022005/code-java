import java.util.Scanner;
public class TongPhanSo {
    private long tuSo;
    private long mauSo;
    public TongPhanSo(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public long getTuSo() {
        return this.tuSo;
    }

    public long getMauSo() {
        return this.mauSo;
    }
    private static long timUocChungLonNhat(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public void rutGon() {
        long uocChung = timUocChungLonNhat(this.tuSo, this.mauSo);
        this.tuSo /= uocChung;
        this.mauSo /= uocChung;
    }
    public static TongPhanSo tong(TongPhanSo p1, TongPhanSo p2) {
        long mauSoChung = p1.getMauSo() * p2.getMauSo();
        long tuSoMoi = p1.getTuSo() * p2.getMauSo() + p2.getTuSo() * p1.getMauSo();

        return new TongPhanSo(tuSoMoi, mauSoChung);
    }
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tu1 = sc.nextLong();
        long mau1 = sc.nextLong();
        TongPhanSo p1 = new TongPhanSo(tu1, mau1);
        long tu2 = sc.nextLong();
        long mau2 = sc.nextLong();
        TongPhanSo p2 = new TongPhanSo(tu2, mau2);
        TongPhanSo tong = TongPhanSo.tong(p1, p2);
        tong.rutGon();
        System.out.println(tong);

        sc.close();
    }
}
