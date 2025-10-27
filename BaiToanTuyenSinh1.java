import java.util.*;

public class BaiToanTuyenSinh1{ 
    private String maTS;
    private String hoten;
    private double diemToan;
    private double diemLy;
    private double diemHoa;
    private double diemUuTien; 
    private double diemXetTuyen; 
    private String trangThai; 

    public static String formatNumber(double num){
        if (num == (long) num){
            return String.format("%d", (long) num);
        }
        return String.format("%.1f", num);
    }
    
    public void xuly(){
        String kv=maTS.substring(0, 3);
        this.diemUuTien=0;
        if (kv.equals("KV1")){
            this.diemUuTien=0.5;
        } else if (kv.equals("KV2")){
            this.diemUuTien=1.0;
        } else if (kv.equals("KV3")){
            this.diemUuTien=2.5;
        }
        
        double tongdiemchuauutien=diemToan*2+diemLy+diemHoa;
        this.diemXetTuyen=tongdiemchuauutien+this.diemUuTien;
        this.trangThai=(this.diemXetTuyen >= 24) ? "TRUNG TUYEN" : "TRUOT";
    }
    
    public void Input(Scanner sc){
        maTS=sc.nextLine();
        hoten=sc.nextLine();
        diemToan=sc.nextDouble();
        diemLy=sc.nextDouble();
        diemHoa=sc.nextDouble();
    }
    
    public BaiToanTuyenSinh1(){
        this.maTS="";
        this.hoten="";
        this.diemToan=0;
        this.diemLy=0;
        this.diemHoa=0;
        this.diemUuTien=0;
        this.diemXetTuyen=0;
        this.trangThai="";
    }
    
    public void Output(){
        System.out.printf("%s %s %s %s %s\n", 
            maTS, 
            hoten, 
            formatNumber(diemUuTien), 
            formatNumber(diemXetTuyen), 
            trangThai
        );
    }
    
    public static void main(String[]args){ 
        Scanner sc=new Scanner(System.in);
        BaiToanTuyenSinh1 ts=new BaiToanTuyenSinh1();
        ts.Input(sc);
        ts.xuly();
        ts.Output();
        sc.close(); 
    }
}