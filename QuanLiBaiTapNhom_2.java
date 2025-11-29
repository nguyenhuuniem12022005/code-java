import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String msv;
    String ten;
    String sdt;
    int nhom;
    String baiTap;

    public Student(String msv, String ten, String sdt, int nhom, String baiTap) {
        this.msv = msv;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = nhom;
        this.baiTap = baiTap;
    }

    @Override
    public int compareTo(Student other) {
        return this.msv.compareTo(other.msv);
    }

    @Override
    public String toString() {
        return this.msv + " " + this.ten + " " + this.sdt + " " + this.nhom + " " + this.baiTap;
    }
}

public class QuanLiBaiTapNhom_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); 


        String[] msvs = new String[n];
        String[] tens = new String[n];
        String[] sdts = new String[n];
        int[] nhoms = new int[n];

        for (int i = 0; i < n; i++) {
            msvs[i] = sc.nextLine();
            tens[i] = sc.nextLine();
            sdts[i] = sc.nextLine();
            nhoms[i] = Integer.parseInt(sc.nextLine());
        }

        ArrayList<String> topics = new ArrayList<>();
        topics.add(""); // Thêm phần tử rỗng cho index 0

        for (int i = 0; i < m; i++) {
            topics.add(sc.nextLine());
        }

        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String baiTapNhom = topics.get(nhoms[i]);
            studentList.add(new Student(msvs[i], tens[i], sdts[i], nhoms[i], baiTapNhom));
        }
        Collections.sort(studentList);

        for (Student sv : studentList) {
            System.out.println(sv);
        }

        sc.close();
    }
}