import java.util.*;
class Point{
    private double x,y;
    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double distance(Point other){
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
public class DienTichHinhTronNgoaiTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            double x1=scanner.nextDouble();
            double y1=scanner.nextDouble();
            double x2=scanner.nextDouble();
            double y2=scanner.nextDouble();
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);
            double d12 = p1.distance(p2);
            double d13 = p1.distance(p3);
            double d23 = p2.distance(p3);
            if (d12+d13<=d23 || d12 + d23<=d13 || d12+d23 <= d13){
                System.out.println("INVALID");
            }else{
                double p=(d12+d23+d13)/2;
                double area=Math.sqrt(p*(p-d12)*(p-d23)*(p-d13));
                double R=(d12*d13*d23)/(4*area);
                double dientichhinhtron=Math.PI * Math.pow(R, 2);
                System.out.printf("%.3f\n", dientichhinhtron);
            }
        }
    }
}