#include <stdio.h>
//void digunakan untuk membuat suatu file dan membukanya dalam mode input data
void insertData() {
    FILE *fptr = fopen("data_mahasiswa.csv", "a"); // Membuka file dalam mode input data
    if (fptr == NULL) {
        printf("Gagal membuka file!\n");
        return;
    }
    //deklarasi nama programstudi dan nim
     char Nama[100],programStudi[100];
	int NIM;
	
	//inputan data
	printf("Masukan Nama :");
	scanf("%s", &Nama);
	printf("Masukan NIM : ");
	scanf("%d", &NIM);
	printf("Masukan Program Studi : ");
	scanf("%s", &programStudi);
	
	//menuliskan data ke file
	  fprintf(fptr,"%-15s|%-15d|%-10s\n|",Nama, NIM, programStudi);
    
	//file ditutup
	fclose(fptr);
	printf("FILE berhasil dibuat");
} 
void tampilkanData() {
    FILE *fptr = fopen("data_mahasiswa.csv", "r"); // Membuka file dalam mode baca
    if (fptr == NULL) {
        printf("Gagal membuka file!\n");
        return;
    }
     //menggunakan while untuk membaca file 
    char buffer[100];
    while (fgets(buffer, sizeof(buffer), fptr)) {
        printf("%s", buffer);
    }

    fclose(fptr); // menutup file
}
int main()
{
	 int pilihan;
	do{
		printf("\nMenu:\n");
        printf("1. Tulis Data Mahasiswa\n");
        printf("2. Tampilkan Data Mahasiswa\n");
        printf("3. Keluar\n");
        printf("Pilih (1-3): ");
        scanf("%d", &pilihan);
        switch(pilihan){
		case 1:
			insertData();
			break;
		case 2:
			tampilkanData();
			break;
		case 3:
			printf("ANDA KELUAR DARI PROGRAM\n");
			break;
		default:
			printf("INPUTAN TIDAK VALID");
		}
	} while(pilihan !=3);
	
	return 0;
}