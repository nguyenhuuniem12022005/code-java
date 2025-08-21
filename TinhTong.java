import java.io.File;
import java.util.Scanner;

public class TinhTong {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("DATA.in"));
        long sum = 0;
        while(sc.hasNext()){
            String s = sc.next();
            try{
                sum += Long.parseLong(s);
            }
            catch(Exception e){

            }
        }
        System.out.println(sum);
    }
}
