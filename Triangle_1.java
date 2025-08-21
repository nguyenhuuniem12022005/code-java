import java.util.Scanner;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}

class Triangle {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public boolean valid() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return a + b > c && b + c > a && c + a > b;
    }

    public String getPerimeter() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double perimeter = a + b + c;
        return String.format("%.3f", perimeter);
    }
}

public class Triangle_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if (!a.valid()) {
                System.out.println("INVALID");
            } else {
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
}