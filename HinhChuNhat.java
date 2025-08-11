import java.util.Scanner;
public class HinhChuNhat {
    public static void main(String[] args){
    Scanner scanner= new Scanner(System.in);
    int chieudai= scanner.nextInt();
    int chieurong=scanner.nextInt();
    int dientich=chieudai * chieurong;
    int chuvi = (chieudai + chieurong) * 2;
    if (chieudai > 0 && chieurong > 0) {
        System.out.printf("%d %d",chuvi,dientich);
    } else {
        System.out.println("0");
    }

}
}