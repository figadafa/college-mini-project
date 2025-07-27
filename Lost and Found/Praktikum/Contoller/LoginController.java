package Praktikum.Contoller;
import Praktikum.Users.Admin;
import Praktikum.Users.Mahasiswa;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
        @FXML
        private TextField usernameField;
        @FXML
        private PasswordField passwordField;

        @FXML
        private void handleLogin() {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Cek apakah login sebagai Admin
            if (isAdminLogin(username, password)) {
                Admin admin = new Admin("Admin Sistem", "123", username, password);
                if (admin.login()) {
                    showAlert("Login Admin berhasil!");
                    // Pindah ke halaman utama admin
                } else {
                    showAlert("Login Admin gagal!");
                }
            }
            // Cek apakah login sebagai Mahasiswa
            else if (isMahasiswaLogin(username, password)) {
                Mahasiswa mahasiswa = new Mahasiswa(username, password);
                if (mahasiswa.login()) {
                    showAlert("Login Mahasiswa berhasil!");
                    // Pindah ke halaman utama mahasiswa
                } else {
                    showAlert("Login Mahasiswa gagal!");
                }
            } else {
                showAlert("Username atau Password tidak valid!");
            }
        }

        private boolean isAdminLogin(String username, String password) {
            // Logika untuk menentukan apakah ini adalah login admin
            return username.equals("admin") && password.equals("admin123"); // Ganti dengan logika yang sesuai
        }

        private boolean isMahasiswaLogin(String username, String password) {
            // Logika untuk menentukan apakah ini adalah login mahasiswa
            return username.equals("Figa Brilliant Daffa") && password.equals("202410370110424"); // Ganti dengan logika yang sesuai
        }

        private void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }


