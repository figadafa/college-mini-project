package Perpustakaan;

public abstract class Buku {
    private String judul;
    private String penulis;
    private int Tahunterbit;

    public Buku(String judul, String penulis, int Tahunterbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.Tahunterbit = Tahunterbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahun() {
        return Tahunterbit;
    }

    public void setTahun(int Tahunterbit) {
        this.Tahunterbit = Tahunterbit;
    }

    public abstract void displayInfo();
}

