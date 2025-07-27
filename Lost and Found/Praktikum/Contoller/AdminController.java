package Praktikum.Contoller;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class AdminController {

    @FXML
    private TableView<ItemStatus> itemsTable;
    @FXML
    private TableColumn<ItemStatus, String> nameColumn;
    @FXML
    private TableColumn<ItemStatus, String> descriptionColumn;
    @FXML
    private TableColumn<ItemStatus, LocalDateTime> dateColumn;
    @FXML
    private TableColumn<ItemStatus, String> locationColumn;
    @FXML
    private TableColumn<ItemStatus, String> statusColumn;

    @FXML
    private Button claimButton;
    @FXML
    private Button logoutButton;

    private ObservableList<ItemStatus> itemsData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Setting up columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load example data
        loadReportedItems();

        itemsTable.setItems(itemsData);

        claimButton.setDisable(true); // Disable claim button initially

        // Add listener for row selection to enable claim button
        itemsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection == null) {
                claimButton.setDisable(true);
            } else {
                claimButton.setDisable(false);
            }
        });
    }

    private void loadReportedItems() {
        itemsData.clear();
        // Example items start with status "Not Claimed"
        itemsData.add(new ItemStatus("Laptop", "Laptop yang hilang",
                LocalDateTime.of(2023, 11, 3, 10, 0), "Ruang Kelas A", "Not Claimed"));
        itemsData.add(new ItemStatus("Buku", "Buku catatan",
                LocalDateTime.of(2023, 11, 3, 15, 30), "Perpustakaan", "Not Claimed"));
    }

    @FXML
    private void handleClaimButton() {
        ItemStatus selectedItem = itemsTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showAlert("Pilih barang yang ingin di-claim terlebih dahulu.");
            return;
        }
        if ("Claimed".equals(selectedItem.getStatus())) {
            showAlert("Barang sudah berstatus Claimed.");
            return;
        }
        // Update status to Claimed
        selectedItem.setStatus("Claimed");
        itemsTable.refresh();
        showAlert("Barang \"" + selectedItem.getName() + "\" berhasil di-claim.");
    }

    @FXML
    private void handleManageUser() {
        showAlert("Fitur mengelola pengguna belum tersedia.");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logout berhasil!");
        // Tambahkan logika kembali ke halaman login jika diperlukan
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Inner class to represent item with status
    public static class ItemStatus {
        private final SimpleStringProperty name;
        private final SimpleStringProperty description;
        private final LocalDateTime date;
        private final SimpleStringProperty location;
        private final SimpleStringProperty status;

        public ItemStatus(String name, String description, LocalDateTime date, String location, String status) {
            this.name = new SimpleStringProperty(name);
            this.description = new SimpleStringProperty(description);
            this.date = date;
            this.location = new SimpleStringProperty(location);
            this.status = new SimpleStringProperty(status);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getDescription() {
            return description.get();
        }

        public void setDescription(String description) {
            this.description.set(description);
        }

        public LocalDateTime getDate() {
            return date;
        }

        public String getLocation() {
            return location.get();
        }

        public void setLocation(String location) {
            this.location.set(location);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status.set(status);
        }
    }
}

