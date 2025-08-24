import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 class Person implements Comparable<Person> {
    private String name;
    private LocalDate dob;
    public Person(String name,String dob_str){
        this.name=name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dob = LocalDate.parse(dob_str, formatter);
    }
    public String getName() {
        return name;
    }
    public LocalDate getDob() {
        return dob;
    }
    public int compareTo(Person other) {
        return this.dob.compareTo(other.dob);
    }
    public String toString(){
        return this.name;
    }
}
public class TreNhatGiaNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String dobStr = sc.next();
            peopleList.add(new Person(name, dobStr));
        }

        Collections.sort(peopleList);

        System.out.println(peopleList.get(peopleList.size() - 1).getName());
        System.out.println(peopleList.get(0).getName());
        
        sc.close();
    }
}