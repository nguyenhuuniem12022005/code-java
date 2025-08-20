import java.util.*;
public class ThiSinh{
    private String Name;
    private String birth;
    private double diem1;
    private double diem2;
    private double diem3;
    ThiSinh(String Name, String birth, double diem1, double diem2, double diem3) {
        this.Name = Name;
        this.birth = birth;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }
    public void display(){
        System.out.print(Name + " " + birth + " ");
        System.out.printf("%.1f",diem1+diem2+diem3);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ThiSinh ts= new ThiSinh(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        ts.display();

    }
}