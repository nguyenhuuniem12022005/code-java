import java.util.*;
class PhanSo{
    private long tu,mau;
    public PhanSo(long tu, long mau){
        this.tu = tu;
        this.mau = mau;
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
        long uocChung = timUocChungLonNhat(this.tu, this.mau);
        this.tu /= uocChung;
        this.mau /= uocChung;
        if (this.mau < 0) {
            this.tu = -this.tu;
            this.mau = -this.mau;
        }
    }
    public long getTu() {
        return this.tu;
    }
    public long getMau() {
        return this.mau;
    }
    public PhanSo tong(PhanSo ps) {
        long newTu = this.tu * ps.getMau() + ps.getTu() * this.mau;
        long newMau = this.mau * ps.getMau();
        PhanSo result = new PhanSo(newTu, newMau);
        result.rutGon();
        return result;
    }
    public PhanSo tich(PhanSo ps) {
        long newTu = this.tu * ps.getTu();
        long newMau = this.mau * ps.getMau();
        PhanSo result = new PhanSo(newTu, newMau);
        result.rutGon();
        return result;
    }
    public String toString(){
        return this.tu + "/" + this.mau;
    }
}
public class TinhToanPhanSo{
    public static void main(String[]args){
        Scanner scanner = new Scanner (System.in);
        int t = scanner.nextInt();
        while(t-->0){
            long tuA = scanner.nextLong();
            long mauA = scanner.nextLong();
            long tuB = scanner.nextLong();
            long mauB = scanner.nextLong();
            PhanSo A=new PhanSo(tuA,mauA);
            PhanSo B=new PhanSo(tuB,mauB);
            PhanSo C=A.tong(B).tich(A.tong(B));
            C.rutGon();
            PhanSo D=A.tich(B).tich(C);
            D.rutGon();
            System.out.println(C + " " + D);
        }
    }
}