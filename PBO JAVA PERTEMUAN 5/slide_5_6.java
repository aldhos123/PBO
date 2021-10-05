public class slide_5_6{
    int modelYear;
    String modelName;

    public slide_5_6(int year, String name){
        modelYear = year;
        modelName = name;
    }

    public static void main(String[] args) {
        slide_5_6 myObj = new slide_5_6(1969, "Mustang");
        System.out.println(myObj.modelYear + " " + myObj.modelName);
    }
}