import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Subject implements Comparable<Subject>{
    private String ma_mon,ten_mon,hinh_thuc;
    public Subject(String ma_mon, String ten_mon, String hinh_thuc) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.hinh_thuc = hinh_thuc;
    }
    @Override
    public int compareTo(Subject o) {
        return this.ma_mon.compareTo(o.ma_mon);
    }
    public String toString(){
        return ma_mon + " " + ten_mon + " " + hinh_thuc;
    }
}
public class DanhSachMonThi{
    public static void main(String[]args){
        try{
            File file = new File("MONHOC.in");
            Scanner sc=new Scanner (file);
            int n= sc.nextInt();
            sc.nextLine();
            List<Subject> subjects = new ArrayList<>();
            for(int i=0;i<n;i++){
                String ma_mon = sc.nextLine();
                String ten_mon = sc.nextLine();
                String hinh_thuc = sc.nextLine();
                subjects.add(new Subject(ma_mon, ten_mon, hinh_thuc));
            }
            Collections.sort(subjects);
            for(Subject s : subjects){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}