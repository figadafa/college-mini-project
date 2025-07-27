import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Codelab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> listBarang = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");

            int opsi;
            try {
                opsi = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (opsi) {
                case 1:
                    // Tambah Barang
                    try {
                        System.out.print("Masukkan Nama Barang : ");
                        String namaBarang = scanner.nextLine();
                        System.out.print("Masukkan Stok Barang : ");
                        int stokBarang = scanner.nextInt();
                        scanner.nextLine(); // konsumsi newline

                        listBarang.add(new Barang(namaBarang, stokBarang));
                        System.out.println("Barang '" + namaBarang + "' berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    // Tampilkan Semua Barang
                    if (listBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\n--- Daftar Barang ---");
                        for (int i = 0; i < listBarang.size(); i++) {
                            Barang b = listBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNamaBarang() + ", Stok: " + b.getStok());
                        }
                        System.out.println("----------------------");
                    }
                    break;

                case 3:
                    // Kurangi Stok Barang
                    if (listBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi.");
                        break;
                    }

                    try {
                        System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                        for (int i = 0; i < listBarang.size(); i++) {
                            Barang b = listBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNamaBarang() + ", Stok: " + b.getStok());
                        }

                        System.out.print("Masukkan nomor indeks barang: ");
                        int index = scanner.nextInt();
                        System.out.print("Masukkan jumlah stok yang ingin dikurangi: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); // konsumsi newline

                        Barang b = listBarang.get(index);

                        if (jumlah > b.getStok()) {
                            throw new StokException("Stok untuk " + b.getNamaBarang() + " hanya tersisa " + b.getStok());
                        }

                        b.setStok(b.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi. Sisa stok: " + b.getStok());

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    } catch (StokException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak tersedia.");
            }
        }
    }
}
