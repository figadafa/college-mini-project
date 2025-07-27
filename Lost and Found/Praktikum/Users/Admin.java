package Praktikum.Users;
import java.util.Scanner;

import Praktikum.Actions.AdminAction;

public class Admin extends User implements AdminAction  {
    private String Username;
    private String Password;
     
     public Admin(String nama,String Nim,String username,String password) {
        super(nama,Nim); // menggunakan super constructor
        this.Username = username;
        this.Password = password;
     }

     @Override
     public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Username Admin : ");
        String InputUsername = scanner.nextLine();
        System.out.print("Masukkan Password Admin : ");
        String InputPassword = scanner.nextLine();
        
        if (InputUsername.equals(Username) && InputPassword.equals(Password)) {
                System.out.println("Login Admin berhasil!");
                System.out.println("Nama : " + getNama());
                System.out.println("NIM  : " + getNim());
                return true;
        } else {
            System.out.println("Login Admin gagal!");
            return false;
        }
     }
     @Override
        public void displayAppMenu(){
            Scanner scanner = new Scanner(System.in);
            int pilihan;
            do{
                System.out.println("/n=======Menu Admin=======");
                System.out.println("1. Manage User");
                System.out.println("2. Manage Item");
                System.out.println("0. Logout");
                System.out.print("Pilih menu (1/2/3): ");
                pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                        ManageItem();
                        break;
                    case 2:
                        ManageUser();
                        break;
                    case 0:
                        System.out.println("Logout berhasil!");
                        break;
                                    
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            }while ((pilihan != 0)); {
                scanner.close();
            }
        }           

     @Override
     public void ManageUser() {
        System.out.println("Fitur ini belum tersedia");
     }

     @Override
     public void ManageItem() {
       System.out.println("Fitur ini belum tersedia");
     }
   
    
    
}
