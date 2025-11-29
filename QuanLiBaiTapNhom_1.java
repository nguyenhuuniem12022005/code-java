import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    String msv;
    String ten;
    String sdt;
    int nhom;

    public Student(String msv, String ten, String sdt, int nhom) {
        this.msv = msv;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return this.msv + " " + this.ten + " " + this.sdt;
    }
}

public class QuanLiBaiTapNhom_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); 

        Map<Integer, ArrayList<Student>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String msv = sc.nextLine();
            String ten = sc.nextLine();
            String sdt = sc.nextLine();
            int nhom = Integer.parseInt(sc.nextLine());
            
            Student sv = new Student(msv, ten, sdt, nhom);
            
            groups.putIfAbsent(nhom, new ArrayList<>());
            groups.get(nhom).add(sv);
        }

        ArrayList<String> topics = new ArrayList<>();
        topics.add(""); 

        for (int i = 0; i < m; i++) {
            topics.add(sc.nextLine());
        }

        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            int queryNhom = Integer.parseInt(sc.nextLine());
            System.out.println("DANH SACH NHOM " + queryNhom + ":");

            ArrayList<Student> members = groups.get(queryNhom);
            if (members != null) {
                for (Student sv : members) {
                    System.out.println(sv);
                }
            }

            System.out.println("Bai tap dang ky: " + topics.get(queryNhom));
        }

        sc.close();
    }
}