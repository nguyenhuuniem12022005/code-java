import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocFileVanBan{
    public static void main(String[]args){
        try{
            File file =new File("DATA.in");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                System.out.println(s);
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }
}