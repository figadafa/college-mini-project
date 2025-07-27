package Praktikum.Contoller;


import Praktikum.Users.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class MahasiswaController {

    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, String> dateColumn;
    @FXML
    private TableColumn<Item, String> locationColumn;

    @FXML
    private void initialize() {
        // Mengatur kolom tabel
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    @FXML
    private void handleReportItem() {
        // Logika untuk melaporkan barang
        showAlert("Fitur melaporkan barang belum tersedia.");
    }

    @FXML
    private void handleViewReportedItems() {
        // Mengisi tabel dengan data barang yang dilaporkan
        loadReportedItems();
        itemsTable.setVisible(true); // Menampilkan tabel
    }

    private void loadReportedItems() {
        itemsTable.getItems().clear(); // Menghapus data sebelumnya
        itemsTable.getItems().add(new Item("Laptop", "Laptop yang hilang",
                LocalDateTime.of(2023, 11, 3, 10, 0), "Ruang Kelas A"));
        itemsTable.getItems().add(new Item("Buku", "Buku catatan",
                LocalDateTime.of(2023, 11, 3, 15, 30), "Perpustakaan"));
    }

    @FXML
    private void handleLogout() {
        // Logika untuk logout
        showAlert("Logout berhasil!");
        // Kembali ke halaman login
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

