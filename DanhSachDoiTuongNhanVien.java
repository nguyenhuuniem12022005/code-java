import java.util.*;
class NhanVien{
    private String maNV;
    private String HoTen;
    private String gioitinh;
    private String ngaysinh;
    private String diachi;
    private String masothue;
    private String ngaykyhopdong;
    public NhanVien(int maNV, String HoTen, String gioitinh, String ngaysinh, String diachi, String masothue, String ngaykyhopdong) {
        this.maNV = String.format("%05d", maNV);
        this.HoTen = HoTen;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.masothue = masothue;
        this.ngaykyhopdong = ngaykyhopdong;
    }
    public String toString(){
        return this.maNV + " " + this.HoTen + " " + this.gioitinh + " " + this.ngaysinh + " " + this.diachi + " " + this.masothue + " " + this.ngaykyhopdong;
    }

}
public class DanhSachDoiTuongNhanVien{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<NhanVien> ds= new ArrayList<>();
        for(int i=0;i<n;i++){
            String HoTen=sc.nextLine();
            String gioitinh=sc.nextLine();
            String ngaysinh=sc.nextLine();
            String diachi=sc.nextLine();
            String masothue=sc.nextLine();
            String ngaykyhopdong=sc.nextLine();
            NhanVien nv=new NhanVien(i+1,HoTen,gioitinh,ngaysinh,diachi,masothue,ngaykyhopdong);
            ds.add(nv);
        }
        for(NhanVien nv:ds){
            System.out.println(nv);
        }
    }
}