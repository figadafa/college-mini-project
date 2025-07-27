package Perpustakaan;

public class Fiksi extends Buku {

   
    private String Genre;

    public  Fiksi(String Penulis, String Judul, int Tahun, String Genre) {
        super(Penulis, Judul, Tahun);
        this.Genre = Genre;
        
    }
    // getter setter 
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }
      
    
    @Override
    public void displayInfo() {
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Tahun Terbit : " + getTahun());
        System.out.println("Genre: " + Genre);
    }

    
    
}