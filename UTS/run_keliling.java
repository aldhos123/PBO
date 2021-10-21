import java.util.Scanner;
public class run_keliling {
    public static void main(String[] args) {
        double bilangan;
        soal_4_keliling anak = new soal_4_keliling();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("Program Menghitung Keliling");
        System.out.println("");
        System.out.print("Masukkan Jari Jari : "); bilangan = keyboard.nextInt();
        System.out.println("===========================");

        anak.keliling(bilangan);
    }
}