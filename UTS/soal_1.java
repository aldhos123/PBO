import java.util.Scanner;

public class soal_1 {
    public static void main(String[] args){
        int jam_awal; int menit_awal; int detik_awal;
        int jam_akhir; int menit_akhir; int detik_akhir;
        int hasilJam_awal, hasilMenit_awal, hasil_awal;
        int hasilJam_akhir, hasilMenit_akhir, hasil_akhir, hasil;
        float hasil_pulsa, hasil_ongkos;

        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("===============================================================");
        System.out.println("Menghitung Biaya Percakapan (Telfon)");
        System.out.println("Keterangan : Masukkan Input Dimulai dari Jam, Menit, lalu Detik");

        System.out.println("Masukkan Waktu Awal : "); 
        System.out.print("Jam : "); jam_awal = keyboard.nextInt();
        System.out.print("Menit : "); menit_awal = keyboard.nextInt();
        System.out.print("Detik : "); detik_awal = keyboard.nextInt();
        
        hasilJam_awal = jam_awal * 3600;
        hasilMenit_awal = menit_awal * 60;
        hasil_awal = hasilJam_awal + hasilMenit_awal + detik_awal;
        
        System.out.println(""); 
        System.out.println("===============================================================");
        System.out.println("JAM AKHIR HARUS LEBIH BESAR DARI JAM AWAL");
        System.out.println("Masukkan Waktu Akhir : "); 
        System.out.print("Jam : "); jam_akhir = keyboard.nextInt();
        System.out.print("Menit : "); menit_akhir = keyboard.nextInt();
        System.out.print("Detik : "); detik_akhir = keyboard.nextInt();
        
        if (jam_akhir <= jam_awal){
            System.out.println("===============================================================");
            System.out.println("MASUKKAN JAM YANG LEBIH BESAR!!!!!");
        }
        hasilJam_akhir = jam_akhir * 3600;
        hasilMenit_akhir = menit_akhir * 60;
        hasil_akhir = hasilJam_akhir + hasilMenit_akhir + detik_akhir;

        hasil = hasil_akhir - hasil_awal;

        hasil_pulsa = hasil / 5;

        hasil_ongkos = hasil_pulsa * 150;

        
        System.out.println("===============================================================");
        System.out.println("Hasil");
        System.out.println("Total Waktu Percakapan : " + hasil + " Detik");
        System.out.println("Total Pulsa Dihabiskan : " + hasil_pulsa);
        System.out.println("Total Biaya Percakapan : Rp. " + hasil_ongkos);
        System.out.println("===============================================================");
    }
}