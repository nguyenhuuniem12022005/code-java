import java.util.*;

public class LietKeSinhVienTheoKhoa {
    static class student {
        String code, name, method, mail;

        public student(String c, String n, String m, String em) {
            code = c;
            name = n;
            method = m;
            mail = em;
        }
        
        @Override
        public String toString() {
            return code + " " + name + ' ' + method + " " + mail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<student> a = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            a.add(new student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String cl = sc.nextLine();
            System.out.printf("DANH SACH SINH VIEN KHOA %s:\n", cl);
            String khoaCanTim = cl.substring(2); 

            a.forEach(e -> {

                if(e.method.substring(1, 3).equals(khoaCanTim)) {
                    System.out.println(e);
                }
            });
        }
        sc.close();
    }
}