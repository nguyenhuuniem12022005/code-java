import java.util.Scanner;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class DienTichTamGiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);

            double d12 = p1.distance(p2);
            double d23 = p2.distance(p3);
            double d31 = p3.distance(p1);

            // Kiểm tra điều kiện tam giác
            if (d12 + d23 <= d31 || d23 + d31 <= d12 || d31 + d12 <= d23) {
                System.out.println("INVALID");
            } else {
                double p = (d12 + d23 + d31) / 2;
                double area = Math.sqrt(p * (p - d12) * (p - d23) * (p - d31));
                System.out.printf("%.2f\n", area);
            }
        }
        scanner.close();
    }
}