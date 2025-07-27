package Perpustakaan;

public class NonFiksi extends Buku {
     private String Kategori ;
        // getter setter
        public String getKategori() {
            return Kategori;
        }
        public void setKategori(String kategori) {
            Kategori = kategori;
        }
     
     public NonFiksi(String Penulis, String Judul, int Tahun, String Kategori) {
        super(Penulis, Judul, Tahun);
        this.Kategori = Kategori;
     }

    @Override
    public void displayInfo() {
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Tahun Terbit : " + getTahun());
        System.out.println("Kategori: " + Kategori);
    }
        
}
    

