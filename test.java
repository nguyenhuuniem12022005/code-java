import java.util.*;
public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter age: ");
        // Read as String, then parse to int
        int age = Integer.parseInt(sc.nextLine()); 
        
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        
        System.out.print("Enter salary: ");
        // Read as String, then parse to int
        int salary = Integer.parseInt(sc.nextLine()); 
        
        Teacher t = new Teacher(name, age, address, salary);
        t.display();
        
        sc.close(); // Good practice to close the Scanner
    }
}