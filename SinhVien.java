import java.util.*;
public class SinhVien{
    private String id;
    private String name;
    private String className;
    private String birth;
    private double gpa;
    SinhVien(){
        id="";
        name="";
        className="";
        birth="";
        gpa=0;
    }
    SinhVien(String id, String name, String className, String birth, double gpa){
        this.id=id;
        this.name=name;
        this.className=className;
        this.birth=birth;
        this.gpa=gpa;
    }
    public void ChuanHoa() {
        String[] parts = this.birth.split("/");
        String ngay = parts[0];
        String thang = parts[1];
        String nam = parts[2];

        if (ngay.length() == 1) {
            ngay = "0" + ngay;
        }
        if (thang.length() == 1) {
            thang = "0" + thang;
        }
        this.birth = ngay + "/" + thang + "/" + nam;
    }
    public void display(){
        System.out.print(id + " " + name + " " + className + " "+ birth+" ");
        
        System.out.printf("%.2f", gpa);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SinhVien sv= new SinhVien("B20DCCN001",sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble());
        sv.ChuanHoa();
        sv.display();
    }
}