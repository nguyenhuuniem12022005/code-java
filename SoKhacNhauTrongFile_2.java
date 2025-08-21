
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.util.TreeMap;

public class SoKhacNhauTrongFile_2 {
    public static void main(String[] args) {
        try {
            DataInputStream obj = new DataInputStream(new FileInputStream("DATA.IN"));
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            for(int i = 0; i < 100000; i++){
                int x = obj.readInt();
                int value = mp.getOrDefault(x, 0) + 1;
                mp.put(x, value);
            }
            for(int x : mp.keySet()){
                System.out.println(x + " " + mp.get(x));
            }
        } catch (Exception e) {
        }
    }

}
