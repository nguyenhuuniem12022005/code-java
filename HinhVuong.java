import java.util.Scanner;

public class HinhVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc tọa độ hình chữ nhật thứ nhất
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        
        // Đọc tọa độ hình chữ nhật thứ hai
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();
        
        // Tìm tọa độ trái dưới và phải trên của hình chữ nhật bao quanh
        int minX = Math.min(x1, x3);
        int minY = Math.min(y1, y3);
        int maxX = Math.max(x2, x4);
        int maxY = Math.max(y2, y4);
        
        // Tính chiều dài và chiều rộng của hình chữ nhật bao quanh
        int length = maxX - minX;
        int width = maxY - minY;
        
        // Cạnh của hình vuông nhỏ nhất là giá trị lớn nhất của chiều dài và chiều rộng
        int side = Math.max(length, width);
        
        // Diện tích hình vuông
        int area = side * side;
        
        System.out.println(area);
        
        scanner.close();
    }
}