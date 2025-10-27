import java.util.*;
class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        setName(name);
        setSalary(salary);
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
        this.name = name;
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary); 
        setBonus(bonus);
    }

    public void setBonus(int bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        } else {
            this.bonus = 0;
        }
    }

    public int getBonus() {
        return bonus;
    }
    @Override
    public void display() {
        super.display(); 

        System.out.println("Bonus: " + bonus);
        System.out.println("Total Income: " + (getSalary() + bonus));

    }
}

public class MainProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        int salary = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Bonus: ");
        int bonus = Integer.parseInt(sc.nextLine());
        sc.close(); 
        Manager manager = new Manager(name, salary, bonus);
        manager.display();
    }
}