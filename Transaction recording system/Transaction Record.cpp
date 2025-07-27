#include <stdio.h>

int main() {
    int transaksi, total, input;

    do {
        total = 0;
        printf("=== Pencatatan Transaksi ===\n");
        printf("Masukkan transaksi selanjutnya (gunakan 0 untuk menyelesaikan):\n");

        // Menggunakan for loop untuk looping transaksi
        for (;;) {  
            scanf("%d", &transaksi);
            if (transaksi == 0) 
			{
				break; 
			} // keluar dari loop jika transaksi = 0
            total += transaksi;
        }

        printf("Total dari transaksi tersebut adalah: %d\n", total);

        // Menanyakan apakah ingin mencatat transaksi lagi
        printf("Apakah Anda ingin mencatat transaksi lagi? (1=Ya, 0=Tidak): ");
        scanf("%d", &input);

    } while (input == 1);

    printf("Terima kasih!\n");
    return 0;
}
