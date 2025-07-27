package Praktikum.Users;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import Praktikum.Actions.MahasiswaAction;

public class Mahasiswa extends User implements MahasiswaAction {
    private List<Item> reportedItems;// Menyimpan barang yang dilaporkan
    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // menggunakan super constructor
        this.reportedItems = new ArrayList<>(); // Inisialisasi list
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Username Nama : ");
        String InputNama = scanner.nextLine();
        System.out.print("Masukkan Password NIM : ");
        String InputNIM = scanner.nextLine();

        if (InputNama.equals(getNama()) && InputNIM.equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            System.out.println("Nama : " + getNama());
            System.out.println("NIM  : " + getNim());
            return true;
        } else {
            System.out.println("Login Mahasiswa gagal!");
            return false;
        }
    }

    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======TEMPAT PELAPORAN TEMUAN BARANG========");
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();

        LocalDateTime waktu = null; // meminta tanggal ditemukan sesuai format
        while (waktu == null) {
            System.out.print("Waktu dan Tanggal (format: yyyy-MM-dd Jam:Menit): ");
            String inputWaktu = scanner.nextLine();
            try {
                waktu = LocalDateTime.parse(inputWaktu, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal salah, mohon masukkan sesuai format yyyy-MM-dd Jam:Menit");
            }
        }


        // Mengambil waktu saat ini
        System.out.print("Lokasi Barang Ditemukan: ");
        String lokasi = scanner.nextLine();

        // Menyimpan barang yang dilaporkan
        reportedItems.add(new Item(namaBarang, deskripsi, waktu, lokasi));
        System.out.println(">> Barang berhasil dilaporkan <<");
    }

    @Override
    public void ViewReportedItem() {
        if (reportedItems.isEmpty()) {
            System.out.println("Tidak ada barang yang dilaporkan.");
            return;
        }

        System.out.println("=======DAFTAR BARANG YANG DILAPORKAN========");
        for (Item item : reportedItems) {
            System.out.println("Nama Barang: " + item.getName());
            System.out.println("Deskripsi: " + item.getDescription());
            System.out.println("Waktu dan Tanggal: " + item.getDate()); // Menampilkan Waktu barang ditemukan
            System.out.println("Lokasi: " + item.getLocation());
            System.out.println("---------------------------------------------");
        }
    }
}
