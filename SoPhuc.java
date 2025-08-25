import java.util.*;
class SP{
    private int phanthuc;
    private int phanao;
    public SP(int phanthuc, int phanao) {
        this.phanthuc = phanthuc;
        this.phanao = phanao;
    }
    public SP cong(SP other) {
        return new SP(this.phanthuc + other.phanthuc, this.phanao + other.phanao);
    }
    public SP nhan(SP other){
        int thucmoi = this.phanthuc * other.phanthuc - this.phanao * other.phanao;
        int anhmoi = this.phanthuc * other.phanao + this.phanao * other.phanthuc;
        return new SP(thucmoi, anhmoi);
    }
     public String toString() {
        if (phanao < 0) {
            return phanthuc + " - " + Math.abs(phanao) + "i";
        }
        return phanthuc + " + " + phanao + "i";
    }
}
public class SoPhuc{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
             int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            SP A = new SP(a, b);
            SP B = new SP(c, d);

            SP tong = A.cong(B);

            SP C = tong.nhan(A);

            SP D = tong.nhan(tong);
            System.out.println(C + ", " + D);
        }
    }
}