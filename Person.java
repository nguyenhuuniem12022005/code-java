public class Person{
    private String name;
    private int age;
    private String address;
    public Person(String name, int age, String address){
        // this.name = name;
        // this.age = age;
        // this.address = address;
        setName(name);
        setAge(age);
        setAddress(address);
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    public void setName(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    public void setAge(int age){
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
    public void setAddress(String address){
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.address = address;
    }
    public void display(){
        System.out.println("name: "+ name+"\n"+
        "Age: "+ age +"\n"+
        "Address: "+ address
        );
    }
}