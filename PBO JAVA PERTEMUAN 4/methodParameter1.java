import java.util.Scanner;
public class methodParameter1 {
    // deklarasi method
    static void barang(int itemA) {
        if (itemA == 1){
            System.out.println("Beras");
        } else if (itemA == 2){
            System.out.println("Tepung");
        } else if (itemA == 3){
            System.out.println("Minyak");
        } else if (itemA == 4){
            System.out.println("Gula");
        } else if (itemA == 5){
            System.out.println("Garam");
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int angka;
        System.out.print("Masukkan Angka Untuk Menampilkan Barang [1-5] = ");
        angka = userInput.nextInt();  

        barang(angka);
    }
}