import java.util.*;
class SV implements Comparable<SV>{
    private String ma;
    private String ten;
    private String lop;
    private String email;

    public SV(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    @Override
    public int compareTo(SV o) {
        int lop_com = this.lop.compareTo(o.lop);
        if (lop_com != 0){
            return lop_com;
        }
        return this.ma.compareTo(o.ma);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s", ma, ten, lop, email);
    }
}

public class SapXepSinhVienTheoLop{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
        List<SV> ds= new ArrayList<>();
        for (int i=0;i<n;i++){
            String ma= sc.nextLine();
            String ten= sc.nextLine();
            String lop= sc.nextLine();
            String email= sc.nextLine();
            ds.add(new SV(ma,ten,lop,email));
        }
        Collections.sort(ds);
        for (SV sv: ds){
            System.out.println(sv);
        }
    }
}