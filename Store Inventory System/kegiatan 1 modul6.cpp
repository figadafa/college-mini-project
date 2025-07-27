#include <stdio.h>
#include <string.h>
//define maks product 100 dan nama file yaitu produk toko.txt
#define MAX_PRODUK 100
#define FILENAME "produk_toko.txt"
//menggunakan typedef dtruct untuk mendefinisikan id,nama,kategori harga serta stok
typedef struct {
    int id;
    char nama[50];
    char kategori[50];
    float harga;
    int stok;
} Produk;
//fungsi void untuk kata penjelas program
void welcomeMessage() {
    printf("====================================\n");
    printf("  Selamat Datang di Manajemen Toko Elektronik\n");
    printf("  Program ini digunakan untuk mengelola produk elektronik.\n");
    printf("====================================\n");
}
//fungsi void untuk tambah produk
void tambahProduk() {
    FILE *file = fopen(FILENAME, "a"); //membuka file dengan mode append untuk penambahan data
    if (file == NULL) {
        printf("Error: Tidak dapat membuka file.\n");
        return;
    }
    //memasukan id produk
    Produk produk;
    printf("Masukkan ID Produk: ");
    scanf("%d", &produk.id);

    // Cek apakah ID sudah terdaftar
    Produk temp;
    int found = 0;
    FILE *checkFile = fopen(FILENAME, "r");
    while (fscanf(checkFile, "%d %s %s %f %d\n", &temp.id, temp.nama, temp.kategori, &temp.harga, &temp.stok) != EOF) {
        if (temp.id == produk.id) {
            found = 1; 
            break;
        }
    }
    fclose(checkFile);

    if (found) {
        printf("ID SUDAH TERDAFTAR. Silakan masukkan ID yang berbeda.\n");
        fclose(file);
        return;
    }
       //menampikan menu tambahkan product
    printf("Masukkan Nama Produk: ");
    scanf("%s", produk.nama);
    printf("Masukkan Kategori Produk: ");
    scanf("%s", produk.kategori);
    printf("Masukkan Harga: ");
    scanf("%f", &produk.harga);
    printf("Masukkan Stok: ");
    scanf("%d", &produk.stok);
      //menam[pilkan ke dalam txt
    fprintf(file, "%d %s %s %.2f %d\n", produk.id, produk.nama, produk.kategori, produk.harga, produk.stok);
    fclose(file);
    printf("Produk berhasil ditambahkan.\n");
}

void tampilkanDaftarProduk() {
    FILE *file = fopen(FILENAME, "r");//membuka file ke mode read
    if (file == NULL) {
        printf("Error: Tidak dapat membuka file.\n");
        return;
    }

    Produk produk; //mendeklarasikan produk dari typedef struct 
    //menampilkan daftar produk di cmd
    printf("Daftar Produk:\n");
    printf("ID\tNama\tKategori\tHarga\t Stok\n");
    while (fscanf(file, "%d %s %s %f %d\n", &produk.id, produk.nama, produk.kategori, &produk.harga, &produk.stok) != EOF) {
        printf("%d\t%s\t%s\t%.2f\t%d\n", produk.id, produk.nama, produk.kategori, produk.harga, produk.stok);
    }
    fclose(file);
}
//uptade informasi product
void updateInformasiProduk() {
    FILE *file = fopen(FILENAME, "r");
    if (file == NULL) {
        printf("Error: Tidak dapat membuka file.\n");
        return;
    }
     
    Produk produk;//mendefinisikan product sebagai produk
    int id;
    printf("Masukkan ID Produk yang ingin diupdate: ");//menanyakan id produk untuk di uptade
    scanf("%d", &id);

    int found = 0; //deklarasi found sebagai 0
    Produk produkList[MAX_PRODUK];//deklarasi array produklist
    int count = 0;
    
    while (fscanf(file, "%d %s %s %f %d\n", &produk.id, produk.nama, produk.kategori, &produk.harga, &produk.stok) != EOF) {
        if (produk.id == id) {
            found = 1;//ketika found = 1 artinya produk ditemukan 
            printf("Masukkan Nama Produk Baru: ");
            scanf("%s", produk.nama);
            printf("Masukkan Kategori Produk Baru: ");
            scanf("%s", produk.kategori);
            printf("Masukkan Harga Baru: ");
            scanf("%f", &produk.harga);
            printf("Masukkan Stok Baru: ");
            scanf("%d", &produk.stok);
        }
        produkList[count++] = produk;
    }
    fclose(file);

    if (!found) { //dan ketika tidak maka produk tidak ditemukan
        printf("Produk dengan ID %d tidak ditemukan.\n", id);
        return;
    }

    file = fopen(FILENAME, "w");//membuka file dalam mode write
    for (int i = 0; i < count; i++) { //menulis ulang produt ke file 
        fprintf(file, "%d %s %s %.2f %d\n", produkList[i].id, produkList[i].nama, produkList[i].kategori, produkList[i].harga, produkList[i].stok);
    }
    fclose(file);//menutup file
    printf("Informasi produk berhasil diupdate.\n");
}
//void untuk menjelaskan 
void hapusProduk() {
    FILE *file = fopen(FILENAME, "r");//membuka file dalam mode read
    if (file == NULL) {
        printf("Error: Tidak dapat membuka file.\n");
        return;
    }

    Produk produk;
    int id;
    printf("Masukkan ID Produk yang ingin dihapus: ");
    scanf("%d", &id);

    int found = 0;
    Produk produkList[MAX_PRODUK];
    int count = 0;

    while (fscanf(file, "%d %s %s %f %d\n", &produk.id, produk.nama, produk.kategori, &produk.harga, &produk.stok) != EOF) {
        if (produk.id != id) {
            produkList[count++] = produk; // jika id produt tidak sesuai maka tetap
        } else {
            found = 1; // ketika idnya sama maka jalan
        }
    }
    fclose(file);

    if (!found) {
        printf("Produk dengan ID %d tidak ditemukan.\n", id);
        return;
    }
    
    file = fopen(FILENAME, "w");
    for (int i = 0; i < count; i++) {
        fprintf(file, "%d %s %s %.2f %d\n", produkList[i].id, produkList[i].nama, produkList[i].kategori, produkList[i].harga, produkList[i].stok);
    }
    fclose(file);
    printf("Produk dengan ID %d berhasil dihapus.\n", id);
}

int main() {
    int pilihan;
    welcomeMessage();
    do {
        printf("\n1. Masukan data produk\n");
        printf("2. Tampilkan daftar produk\n");
        printf("3. uptade data produk\n");
        printf("4. Hapus data produk\n");
        printf("5.  keluar\n");
        printf("Pilih menu: ");
        scanf("%d", &pilihan);

        switch (pilihan) {
            case 1:
                tambahProduk();
                break;
            case 2:
                tampilkanDaftarProduk();
                break;
            case 3:
                updateInformasiProduk();
                break;
            case 4:
                hapusProduk();
                break;
            case 5:
                printf("Terima kasih! Program selesai.\n");
                   break;
            default:
                printf("Pilihan tidak valid. Silakan coba lagi.\n");
        }
    }while(pilihan!=5);
	
    return 0;
}