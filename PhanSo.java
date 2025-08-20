import java.util.Scanner;
public class PhanSo {
    private long tuSo;
    private long mauSo;
    public PhanSo(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    private long timUocChungLonNhat(long a, long b) {
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
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tu = sc.nextLong();
        long mau = sc.nextLong();
        PhanSo p = new PhanSo(tu, mau);
        p.rutGon();
        System.out.println(p);

        sc.close();
    }
}

