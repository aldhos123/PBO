import java.util.Scanner;
public class run_luas {
    public static void main(String[] args) {
        double bilangan;
        soal_4_luas anak = new soal_4_luas();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Program Menghitung Luas");
        System.out.println("");
        System.out.print("Masukkan Jari Jari : "); bilangan = keyboard.nextInt();
        System.out.println("===========================");

        anak.luas(bilangan);
    }
}