import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MatHang implements Comparable<MatHang> {
    private String id, name, unit;
    private long buyPrice;
    private int quantity;
    private long transportFee, totalCost, retailPrice;

    public MatHang(int count, String name, String unit, long buyPrice, int quantity) {
        this.id = String.format("MH%02d", count);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.quantity = quantity;
        calculatePrices();
    }
    
    private void calculatePrices() {
        long totalBuyPrice = buyPrice * quantity;
        this.transportFee = Math.round(totalBuyPrice * 0.05);

        this.totalCost = Math.round(totalBuyPrice + this.transportFee);
        double retailPricePerItem = (this.totalCost * 1.02) / this.quantity;
        this.retailPrice = (long) Math.ceil(retailPricePerItem / 100) * 100;
    }
    @Override
    public int compareTo(MatHang other) {
        return Long.compare(other.retailPrice, this.retailPrice);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", id, name, unit, transportFee, totalCost, retailPrice);
    }
}

public class TinhGiaBan_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<MatHang> danhSachMatHang = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String unit = scanner.nextLine();
            long buyPrice = Long.parseLong(scanner.nextLine());
            int quantity = Integer.parseInt(scanner.nextLine());
            danhSachMatHang.add(new MatHang(i + 1, name, unit, buyPrice, quantity));
        }

        Collections.sort(danhSachMatHang);

        for (MatHang mh : danhSachMatHang) {
            System.out.println(mh);
        }
        
        scanner.close();
    }
}