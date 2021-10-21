import java.util.Scanner;
    public class soal_3{

        public static void main(String[] args) {
                Scanner keyboard = new Scanner(System.in);
                int bilangan, hasil_bilangan = 0;
        
                System.out.println("================================================");
                System.out.println("Program 10 Buah Menghitung Bilangan Bulat");
                System.out.println("");
        
                for (int i = 1; i <= 10; i++) {
                    System.out.print("Bilangan " + i +" : "); bilangan = keyboard.nextInt();
                    hasil_bilangan += bilangan;
                }

                System.out.println("Jumlah dari bilangan bulat yang anda inputkan adalah = " + hasil_bilangan);
                System.out.println("================================================");
        }
    }