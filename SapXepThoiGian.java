import java.util.*;
class Time implements Comparable<Time>{
    private int gio,phut,giay;
    public Time (int gio, int phut, int giay){
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }
    public int compareTo(Time other){
        if (this.gio != other.gio) {
            return Integer.compare(this.gio, other.gio);
        }
        if (this.phut != other.phut) {
            return Integer.compare(this.phut, other.phut);
        }
        return Integer.compare(this.giay, other.giay);
    }
    public String toString(){
        return this.gio + " " + this.phut + " " + this.giay;
    }

}
public class SapXepThoiGian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            int s = scanner.nextInt();
            times.add(new Time(h, m, s));
        }
        
        Collections.sort(times);
        
        for (Time t : times) {
            System.out.println(t);
        }
        
        scanner.close();
    }
}