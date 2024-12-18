/*
 * Nama     : Andini Tribuana
 * NIM      : 244107060140
 * No Absen : 02
 */

 import java.util.Scanner;

 public class UAS1E02 {
     static Scanner sc = new Scanner(System.in);
     static String[] namaTim;
     static int[][] skor;
     static int jmlTim;
     static final int noAbsen = 2; 
 
     public static void main(String[] args) {
         int pilihan;
 
         do {
             System.out.println("\n===== MENU UTAMA =====");
             System.out.println("1. Input Data Skor Tim");
             System.out.println("2. Tampilkan Tabel Skor");
             System.out.println("3. Tentukan Juara");
             System.out.println("4. Keluar");
             System.out.print("Pilih menu (1-4): ");
             pilihan = sc.nextInt();
 
             switch (pilihan) {
                 case 1:
                     inputData02();
                     break;
                 case 2:
                     tampilTabel02();
                     break;
                 case 3:
                     tentukanJuara02();
                     break;
                 case 4:
                     System.out.println("Keluar dari program. Terimakasih!.");
                     break;
                 default:
                     System.out.println("Pilihan tidak valid. Masukkan angka 1-4.");
             }
         } while (pilihan != 4);
     }
 
     // Input data tim
     static void inputData02() {
         int input;
         System.out.print("\nMasukkan angka untuk menghitung jumlah tim: ");
         input = sc.nextInt();
 
         jmlTim = (input % 3) + 4;
         System.out.println("Jumlah tim yang akan dimasukkan: " + jmlTim);
 
         namaTim = new String[jmlTim];
         skor = new int[jmlTim][2];
 
         for (int i = 0; i < jmlTim; i++) {
             sc.nextLine();
             System.out.print("\nMasukkan nama tim ke-" + (i + 1) + ": ");
             namaTim[i] = sc.nextLine();
 
             while (true) {
                 System.out.print("Masukkan skor " + namaTim[i] + " untuk Level 1: ");
                 int level1 = sc.nextInt();
                 if (level1 < 0) {
                     System.out.println("Skor tidak boleh negatif. Masukkan ulang!");
                 } else if (level1 < 35) {
                     System.out.println("Skor Level 1 kurang dari 35, dianggap 0.");
                     skor[i][0] = 0;
                     break;
                 } else {
                     skor[i][0] = level1;
                     break;
                 }
             }
 
             while (true) {
                 System.out.print("Masukkan skor " + namaTim[i] + " untuk Level 2: ");
                 int level2 = sc.nextInt();
                 if (level2 < 0) {
                     System.out.println("Skor tidak boleh negatif. Masukkan ulang!");
                 } else {
                     skor[i][1] = level2;
                     break;
                 }
             }
         }
     }
 
     // Menampilkan tabel skor
     static void tampilTabel02() {
         if (namaTim == null || jmlTim == 0) {
             System.out.println("Tidak ada data yang bisa ditampilkan.");
             return;
         }
 
         System.out.println("\n===== Tabel Skor Turnamen =====");
         System.out.printf("%-15s %-8s %-8s %-8s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
 
         for (int i = 0; i < jmlTim; i++) {
             int totSkor = skor[i][0] + skor[i][1];
 
             if (totSkor % 2 == 0) {
                 totSkor -= 15;
             }
 
             if (skor[i][0] > 50 && skor[i][1] > 50) {
                 totSkor += noAbsen;
             }
 
             System.out.printf("%-15s %-8d %-8d %-8d\n", namaTim[i], skor[i][0], skor[i][1], totSkor);
         }
     }
 
     // Menentukan juara
     static void tentukanJuara02() {
         if (namaTim == null || jmlTim == 0) {
             System.out.println("Tidak ada data yang bisa ditampilkan.");
             return;
         }
 
         int juara = 0;
         int skorTerbesar = skor[0][0] + skor[0][1];
         int skorLvl12Bsr = skor[0][1]; 
 
         boolean seri = false;
 
         for (int i = 1; i < jmlTim; i++) {
             int totSkor = skor[i][0] + skor[i][1];
             int totSkorLvl12 = skor[i][1];
 
             if (totSkor > skorTerbesar || (totSkor == skorTerbesar && totSkorLvl12 > skorLvl12Bsr)) {
                 skorTerbesar = totSkor;
                 skorLvl12Bsr = totSkorLvl12;
                 juara = i;
                 seri = false; 
             } else if (totSkor == skorTerbesar && totSkorLvl12 == skorLvl12Bsr) {
                 seri = true; 
             }
         }
 
         if (seri) {
             System.out.println("\nTurnamen berakhir seri. Tim terbaik adalah Tim Andini Tribuana.");
         } else {
             System.out.println("\nSelamat kepada Tim " + namaTim[juara] + " yang telah memenangkan kompetisi!");
         }
     }
 }
 