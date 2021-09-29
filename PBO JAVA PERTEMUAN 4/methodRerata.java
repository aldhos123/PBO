import java.util.Scanner;
public class methodRerata {
    // deklarasi method
    static int i = 0;
    static int total() {
        int bilangan, total = 0, hasil = 0;
        char jawab = 'y';
        Scanner userInput = new Scanner(System.in);
        while(jawab == 'y'){
            System.out.print("Masukkan bilangan = ");
            bilangan = userInput.nextInt();  

            total = total + bilangan;
            System.out.print("Ingin menambah bilangan? [Y/T]");
            jawab = userInput.next().charAt(0);
            i++;
        }
        return total;
    }

    static double hasil(int a, int b) {
        double hasil = a / b;
        return hasil;
    }

    public static void main(String[] args) {
        System.out.println("\n================================");
        int jum = total();
        double h = hasil(jum, i);
        System.out.println("Jumlah nilainya adalah = " + jum);
        System.out.println("Rata ratanya adalah = " + h);
        System.out.println("================================\n");
    }
}