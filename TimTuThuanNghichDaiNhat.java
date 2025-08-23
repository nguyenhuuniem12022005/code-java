import java.util.*;
public class TimTuThuanNghichDaiNhat{
    public static boolean DoiXung(String word){
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return sb.toString().equals(word);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner (System.in);
        Map<String,Integer> mp=new LinkedHashMap<>();
        int max_l=0;
        while(sc.hasNext()){
            String word=sc.next();
            if (DoiXung(word)){
                mp.put(word,mp.getOrDefault(word,0)+1);
                if (word.length()> max_l){
                    max_l=word.length();
                }
            }
        }
            for (Map.Entry<String,Integer> entry:mp.entrySet()){
                if(entry.getKey().length()==max_l){
                    System.out.println(entry.getKey()+" "+entry.getValue());
                }
            }
        
    }
}