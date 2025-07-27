package Perpustakaan;
import Perpustakaan.Buku;
public interface Peminjaman {
    void pinjamBuku(Buku buku); // Method overloading tanpa durasi pinjam
    void pinjamBuku(Buku buku, int durasiPinjam); // Method overloading dengan durasi pinjam
    void kembalikanBuku(Buku buku); // Method untuk mengembalikan buku
}
