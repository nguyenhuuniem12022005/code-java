import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class SoKhacNhauTrongFile_1 {
    public static void main(String[] args) {
        try {
            File f = new File("DATA.in");
            Scanner sc = new Scanner(f);
            Map<Integer, Integer> map = new TreeMap<>();
            while(sc.hasNextInt()){
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue() );
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}