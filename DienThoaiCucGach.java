import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DienThoaiCucGach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
         scanner.nextLine();
        Map<Character, Character> phoneMap = new HashMap<>();
        phoneMap.put('A', '2'); phoneMap.put('B', '2'); phoneMap.put('C', '2');
        phoneMap.put('D', '3'); phoneMap.put('E', '3'); phoneMap.put('F', '3');
        phoneMap.put('G', '4'); phoneMap.put('H', '4'); phoneMap.put('I', '4');
        phoneMap.put('J', '5'); phoneMap.put('K', '5'); phoneMap.put('L', '5');
        phoneMap.put('M', '6'); phoneMap.put('N', '6'); phoneMap.put('O', '6');
        phoneMap.put('P', '7'); phoneMap.put('Q', '7'); phoneMap.put('R', '7'); phoneMap.put('S', '7');
        phoneMap.put('T', '8'); phoneMap.put('U', '8'); phoneMap.put('V', '8');
        phoneMap.put('W', '9'); phoneMap.put('X', '9'); phoneMap.put('Y', '9'); phoneMap.put('Z', '9');
        while (t-->0){
            String s=scanner.nextLine();
            s=s.toUpperCase();
            StringBuilder sb=new StringBuilder();
            for (char c:s.toCharArray()){
                if (phoneMap.containsKey(c)){
                    sb.append(phoneMap.get(c));
                }
                
            }
            String k =sb.toString();
            boolean thuannghich=true;
            for (int i=0;i<k.length()/2;i++){
                if (k.charAt(i)!=k.charAt(k.length()-1-i)){
                    thuannghich=false;
                    break;
                }
            }
            if (thuannghich){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }


    }
}    
