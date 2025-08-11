import java.util.Scanner;
public class tinhtongnsonguyenduongdautien {
    public static void main(String[] args){
    Scanner scanner= new Scanner(System.in);
    int k= scanner.nextInt();
    while (k-- > 0) {
        long n= scanner.nextInt();
        long tong=n *(n+1)/2;
        System.out.printf("%d",tong);
        if (k > 0) {
            System.out.println();
        }
    
    }
    }
}