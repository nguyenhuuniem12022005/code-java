import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CLB {
    private String ten;
    private int giaVe;

    public CLB(String ten, int giaVe) {
        this.ten = ten;
        this.giaVe = giaVe;
    }

    public String getTen() {
        return ten;
    }

    public int getGiaVe() {
        return giaVe;
    }
}

public class CauLacBoBongDa1 {
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
        for (int i = 0; i < m; i++) {
            String maTran = sc.next();
            int soCDV = sc.nextInt();

            String maCLBTranDau = maTran.substring(1, 3);
            
            CLB clbHienTai = clbMap.get(maCLBTranDau);
            
            long doanhThu = (long) clbHienTai.getGiaVe() * soCDV;

            System.out.println(maTran + " " + clbHienTai.getTen() + " " + doanhThu);
        }
        
        sc.close();
    }
}