import java.util.*;

class CLB {
    private String ten;
    private int giaVe;

    public CLB(String ten, int giaVe) {
        this.ten = ten;
        this.giaVe = giaVe;
    }
    public String getTen() { return ten; }
    public int getGiaVe() { return giaVe; }
}

class TranDau implements Comparable<TranDau> {
    private String maTran;
    private String tenDoi;
    private long doanhThu;

    public TranDau(String maTran, String tenDoi, long doanhThu) {
        this.maTran = maTran;
        this.tenDoi = tenDoi;
        this.doanhThu = doanhThu;
    }

    @Override
    public int compareTo(TranDau other) {
        if (this.doanhThu != other.doanhThu) {
            return Long.compare(other.doanhThu, this.doanhThu);
        }
        return this.tenDoi.compareTo(other.tenDoi);
    }
    
    @Override
    public String toString() {
        return maTran + " " + tenDoi + " " + doanhThu;
    }
}

public class CauLacBoBongDa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        Map<String, CLB> clbMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int giaVe = Integer.parseInt(sc.nextLine());
            clbMap.put(ma, new CLB(ten, giaVe));
        }

        int m = sc.nextInt();
        List<TranDau> danhSachTranDau = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String maTran = sc.next();
            int soCDV = sc.nextInt();

            String maCLB = maTran.substring(1, 3);
            CLB clb = clbMap.get(maCLB);
            long doanhThu = (long) clb.getGiaVe() * soCDV;
            
            danhSachTranDau.add(new TranDau(maTran, clb.getTen(), doanhThu));
        }
        
        Collections.sort(danhSachTranDau);

        for (TranDau tran : danhSachTranDau) {
            System.out.println(tran);
        }
        
        sc.close();
    }
}