import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;
public class TachDoiVaTinhTong{
    public static void main(String[] args){
        try{
        File file = new File("DATA.in");
        Scanner sc= new Scanner(file);
        if (sc.hasNextBigInteger()){
            BigInteger num=sc.nextBigInteger();
            String str=num.toString();
            while(str.length()>1){
                int l=str.length();
                int halfl=l/2;
                BigInteger first=new BigInteger(str.substring(0, halfl));
                BigInteger second=new BigInteger(str.substring(halfl));
                BigInteger sum=first.add(second);
                str=sum.toString();
                System.out.println(str);
            }
        }

    }catch(FileNotFoundException e){
        System.out.println("File not found");
    }
}
}