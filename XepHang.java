import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class XepHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[][] guests = new int[n][2];
        for (int i = 0; i < n; i++) {
            guests[i][0] = scanner.nextInt(); // Thời điểm đến
            guests[i][1] = scanner.nextInt(); // Thời gian làm thủ tục
        }

        // Sắp xếp mảng hai chiều dựa trên cột đầu tiên (thời điểm đến)
        Arrays.sort(guests, Comparator.comparingInt(a -> a[0]));

        int lastFinishTime = 0;
        for (int i = 0; i < n; i++) {
            int arrivalTime = guests[i][0];
            int duration = guests[i][1];
            
            // Thời gian bắt đầu làm thủ tục
            int startTime = Math.max(arrivalTime, lastFinishTime);
            
            // Thời gian hoàn thành
            int finishTime = startTime + duration;
            
            lastFinishTime = finishTime;
        }

        System.out.println(lastFinishTime);
        
        scanner.close();
    }
}