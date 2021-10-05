abstract class Person {
    public String fname = "John";
    public int age = 24;
    public abstract void study(); // abstract method
}
class Student extends Person{
    public int graduationYear = 2018;
    public void study() {// the body of the abstract method is provided here
    System.out.println("Studying all day long");
    }
}
class slide_5_5 {
public static void main(String[] args) {
    Student myObj = new Student ();

        System.out.println("Name: " + myObj .fname);
        System.out.println("Age: " + myObj.age);
        System.out.println("Graduation Year: " + myObj.graduationYear);
        myObj.study(); // call abstract method
    }
}