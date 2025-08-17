import java.util.*;
public class DanhDauChuCai{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Set<Character> set= new HashSet<>();
        String input=sc.nextLine();
        for(char c: input.toCharArray()){
            set.add(c);
        }
        System.out.println(set.size());
        sc.close();
    }
}