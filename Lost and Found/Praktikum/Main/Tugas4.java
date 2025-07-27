package Praktikum.Main;

import Praktikum.Users.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Tugas4 extends Application {
    private User user;

    public static void main(String[] args) {
        launch(args); // Memulai aplikasi JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistem Login");

        // Membuat elemen GUI
        Label label = new Label("=== Sistem Login ===");
        Button adminButton = new Button("Login sebagai Admin");
        Button mahasiswaButton = new Button("Login sebagai Mahasiswa");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // Event handler untuk login sebagai Admin
        adminButton.setOnAction(e -> {
            Admin admin = new Admin("Admin Sistem", "123", "admin", "admin123");
            if (admin.login()) {
                user = admin;
                outputArea.setText("Login Admin berhasil!");
                admin.displayAppMenu();
            } else {
                outputArea.setText("Login Admin gagal!");
            }
        });

        // Event handler untuk login sebagai Mahasiswa
        mahasiswaButton.setOnAction(e -> {
            Mahasiswa mahasiswa = new Mahasiswa("Figa Brilliant Daffa", "202410370110424");
            if (mahasiswa.login()) {
                user = mahasiswa;
                outputArea.setText("Login Mahasiswa berhasil!");
                mahasiswa.ReportItem();
            } else {
                outputArea.setText("Login Mahasiswa gagal!");
            }
        });

        // Menambahkan elemen ke layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, adminButton, mahasiswaButton, outputArea);

        // Membuat scene dan menampilkannya
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
