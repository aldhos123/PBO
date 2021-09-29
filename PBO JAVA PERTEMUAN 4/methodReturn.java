public class mehtodReturn {
    static int mymethod(int x, int y){
        return x + y;
    }

    public static void main(String[] args){
        int z = mymethod(5, 3);
        System.out.println(z);
    }
}