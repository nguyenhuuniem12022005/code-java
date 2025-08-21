import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoaiBoSoNguyen {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        
        try {
            File file = new File("DATA.in");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String token = sc.next();
                if (!isInteger(token)) {
                    result.add(token);
                }
            }
            
            sc.close();
            Collections.sort(result);
            for (String s : result) {
                System.out.print(s + " ");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy file DATA.in");
        }
    }
}