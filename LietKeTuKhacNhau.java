import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LietKeTuKhacNhau {
    public static void main(String[] args) {
        String fileName = "VANBAN.in";
        Set<String> uniqueWords = new TreeSet<>();

        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();
                uniqueWords.add(word);
            }
            sc.close();
            for (String word : uniqueWords) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {

            System.err.println("Lỗi: Không tìm thấy file '" + fileName + "'");
        }
    }
}