import java.util.*;

public class GiaoHaiDaySo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();
        for(int i = 0; i < n; i++){
            setA.add(scanner.nextInt());
        }
        for(int i = 0; i < m; i++){
            setB.add(scanner.nextInt());
        }
        setA.retainAll(setB);
        for(int num : setA){
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
}