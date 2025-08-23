import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ThiSinh {
    private int maTS;
    private String ten;
    private String ngaySinh;
    private double tongDiem;

    public ThiSinh(int maTS, String ten, String ngaySinh, double diem1, double diem2, double diem3) {
        this.maTS = maTS;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.tongDiem = diem1 + diem2 + diem3;
    }

    public int getMaTS() {
        return maTS;
    }

    public double getTongDiem() {
        return tongDiem;
    }
    
    @Override
    public String toString() {
        return maTS + " " + ten + " " + ngaySinh + " " + tongDiem;
    }
}

public class TimThuKhoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double maxScore = -1.0;
        List<ThiSinh> danhSachThiSinh = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ten = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            double diem1 = Double.parseDouble(scanner.nextLine());
            double diem2 = Double.parseDouble(scanner.nextLine());
            double diem3 = Double.parseDouble(scanner.nextLine());
            
            ThiSinh ts = new ThiSinh(i + 1, ten, ngaySinh, diem1, diem2, diem3);
            danhSachThiSinh.add(ts);
            
            if (ts.getTongDiem() > maxScore) {
                maxScore = ts.getTongDiem();
            }
        }
        
        List<ThiSinh> thuKhoaList = new ArrayList<>();
        for (ThiSinh ts : danhSachThiSinh) {
            if (ts.getTongDiem() == maxScore) {
                thuKhoaList.add(ts);
            }
        }
        thuKhoaList.sort(Comparator.comparingInt(ThiSinh::getMaTS));
        
        for (ThiSinh ts : thuKhoaList) {
            System.out.println(ts);
        }
        
        scanner.close();
    }
}