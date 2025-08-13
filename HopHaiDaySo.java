import java.util.*;
public class HopHaiDaySo{
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeSet<Integer> setA = new TreeSet<>();
        
        for(int i = 0; i < n; i++){
            setA.add(scanner.nextInt());
        }
        for(int i = 0; i < m; i++){
            setA.add(scanner.nextInt());
        }
        for(int num : setA){
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
}