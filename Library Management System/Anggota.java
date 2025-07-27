package Perpustakaan;

public class Anggota implements Peminjaman {
    private String nama;
    private String IdAnggota;

    //constructor
    public Anggota(String nama, String IdAnggota){
        this.nama = nama;
        this.IdAnggota = IdAnggota;
    }

    //getter setter
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getIdAnggota() {
        return IdAnggota;
    }
    public void setIdAnggota(String idAnggota) {
        IdAnggota = idAnggota;
    }

    //method
    public void displayInfo() {
        System.out.println("Nama Anggota: " + nama);
        System.out.println("ID Anggota: " + IdAnggota);
    }
    @Override
    public void pinjamBuku(Buku buku) {
      System.out.println( nama + " meminjam " + buku.getJudul() + " Karya " + buku.getPenulis() );
    }
    @Override
    public void pinjamBuku(Buku buku, int durasiPinjam) {
        System.out.println( nama + " meminjam: " + buku.getJudul() + " Karya " + buku.getPenulis() + " selama " + durasiPinjam + " hari.");
    }
    @Override
    public void kembalikanBuku(Buku buku) {
        System.out.println( nama + " mengembalikan " + buku.getJudul() + " Karya " + buku.getPenulis());
    }
}
