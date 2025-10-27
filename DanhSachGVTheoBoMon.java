
import java.util.ArrayList;
import java.util.Scanner;


public class DanhSachGVTheoBoMon {
    public static String shorten(String s) {
        String[] splitted = s.split("\\s+");
        String res = "";
        for (String i : splitted) {
            if (!i.trim().isEmpty()) res += i.substring(0,1).toUpperCase();
        }
        return res;
    }
    static class gv implements Comparable<gv> {
        String id,name,subject;
        public gv(int i, Scanner input) {
            this.id = String.format("GV%02d", i);
            this.name = input.nextLine();
            this.subject = shorten(input.nextLine());
        }
        @Override
        public String toString() {
            return String.format("%s %s %s", this.id, this.name, this.subject);
        }
        @Override
        public int compareTo(gv other) {
            String[] splitted1 = this.name.split("\\s+");
            String[] splitted2 = other.name.split("\\s+");
            if (splitted1[splitted1.length-1].equals(splitted2[splitted2.length-1])) {
                return this.id.compareTo(other.id);
            }
            return splitted1[splitted1.length-1].compareTo(splitted2[splitted2.length-1]);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        ArrayList<gv> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(new gv(i,input));
        }
        int k = Integer.parseInt(input.nextLine());
        while (k-->0) {
            String major = shorten(input.nextLine());
            System.out.printf("DANH SACH GIANG VIEN BO MON %s:\n", major);
            for (gv i : res){
                if (i.subject.equals(major)) System.out.println(i);
            }
        }
    }
}