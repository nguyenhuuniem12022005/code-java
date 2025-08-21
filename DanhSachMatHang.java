import java.util.*;
class Hang implements Comparable<Hang>{
    private String ma ,ten,donvi;
    private int giamua,giaban,loinhuan;
    public Hang(int dem,String ten,String donvi,int giamua,int giaban){
        this.ma = "MH" + String.format("%03d", dem);
        this.ten = ten;
        this.donvi = donvi;
        this.giamua = giamua;
        this.giaban = giaban;
        this.loinhuan = giaban - giamua;
    }
    public int getLoinhuan() {
        return loinhuan;
    }
    public String ma(){
        return this.ma;
    }
    public int compareTo(Hang other) {
       if (this.loinhuan != other.loinhuan) {
           return Integer.compare(other.loinhuan, this.loinhuan);
       }
       return this.ma.compareTo(other.ma);
    }
    public String toString() {
        return ma + " " + ten + " " + donvi + " " + giamua + " " + giaban + " " + loinhuan;
    }
}
public class DanhSachMatHang{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();

        List<Hang> products = new ArrayList<>();
        for (int i=0;i<m;i++){
            String ten = scanner.nextLine();
            String donvi = scanner.nextLine();
            int giamua = Integer.parseInt(scanner.nextLine());
            int giaban = Integer.parseInt(scanner.nextLine());
            products.add(new Hang(i+1,ten,donvi,giamua,giaban));
        }
        Collections.sort(products);
        for (Hang product : products) {
            System.out.println(product);
        }
    }
}