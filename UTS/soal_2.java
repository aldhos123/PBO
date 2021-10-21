import java.util.Scanner;
public class soal_2 {
    // deklarasi method
    static void ideal(float itemA) {
        if (itemA >= 18.5 && itemA <= 22.9){
            System.out.println(itemA + " = Berat Badan Anda Normal (Ideal)");
        } else if (itemA <= 18.5){
            System.out.println(itemA + " = Berat Badan Anda Underweight");
        } else if (itemA >= 22.9){
            System.out.println(itemA + " = Berat Badan Anda Overweight");
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        float berat_badan, tinggi_badan, berat_badan_ideal, hasil_badan;

        System.out.println("================================================");
        System.out.println("Program Berat Badan Ideal");
        System.out.println("");
        System.out.print("Masukkan Berat Badan [kg]  : "); berat_badan = keyboard.nextInt();
        System.out.print("Masukkan Tinggi Badan [cm]  : "); tinggi_badan = keyboard.nextInt();

        berat_badan_ideal = berat_badan / ((tinggi_badan/100) * (tinggi_badan/100));

        ideal(berat_badan_ideal);
        System.out.println("================================================");
    }
}