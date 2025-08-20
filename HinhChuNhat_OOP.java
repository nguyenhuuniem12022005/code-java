import java.util.*;
public class HinhChuNhat_OOP{
    private int width;
    private int height;
    private String color;
    public HinhChuNhat_OOP(){
        this.width = 1;
        this.height = 1;
    }
    public HinhChuNhat_OOP(int width, int height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    public int findarea(){
        return this.width * this.height;
    }
    public int findperimeter(){
        return 2 * (this.width + this.height);
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        String color = sc.next();
        
        if (width<=0 || height<=0){
            System.out.println("INVALID");
        }else{
           HinhChuNhat_OOP hcn = new HinhChuNhat_OOP(width, height, color);
           String chuanhoa_mau=hcn.getColor().substring(0, 1).toUpperCase() +
                                       hcn.getColor().substring(1).toLowerCase();
           System.out.println(hcn.findperimeter() + " " + hcn.findarea() + " " + chuanhoa_mau);                  
        }
    }
}