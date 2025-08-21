import java.util.*;
class Point3D{
    private int x,y,z;
    public Point3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static boolean check(Point3D p1, Point3D p2,Point3D p3,Point3D p4){
        int u1 = p2.x - p1.x;
        int u2 = p2.y - p1.y;
        int u3 = p2.z - p1.z;
        
        int v1 = p3.x - p1.x;
        int v2 = p3.y - p1.y;
        int v3 = p3.z - p1.z;
        
        int w1 = p4.x - p1.x;
        int w2 = p4.y - p1.y;
        int w3 = p4.z - p1.z;
        
        int nx = u2 * v3 - u3 * v2;
        int ny = u3 * v1 - u1 * v3;
        int nz = u1 * v2 - u2 * v1;
        long result = (long)nx * w1 + (long)ny * w2 + (long)nz * w3;
        return result == 0;
    }

}
public class BonDiemTrenMatPhang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
            
            if(Point3D.check(p1,p2,p3,p4)){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}