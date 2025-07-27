import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
Import

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField num1Field = new TextField();
        num1Field.setPromptText("Angka pertama");

        TextField num2Field = new TextField();
        num2Field.setPromptText("Angka kedua");

        ComboBox<String> operatorBox = new ComboBox<>();
        operatorBox.getItems().addAll("+", "-", "*", "/");
        operatorBox.setPromptText("Pilih operator");

        Button calcButton = new Button("Hitung");
        Label resultLabel = new Label("Hasil: ");

        calcButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                String op = operatorBox.getValue();

                Operation operation;
                switch (op) {
                    case "+": operation = new Addition(); break;
                    case "-": operation = new Subtraction(); break;
                    case "*": operation = new Multiplication(); break;
                    case "/": operation = new Division(); break;
                    default:
                        resultLabel.setText("Pilih operator!");
                        return;
                }

                Calculator calculator = new Calculator();
                double result = calculator.performCalculation(operation, num1, num2);
                resultLabel.setText("Hasil: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Masukkan angka valid!");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Terjadi kesalahan");
            }
        });

        VBox layout = new VBox(10, num1Field, operatorBox, num2Field, calcButton, resultLabel);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 250);
        stage.setTitle("Kalkulator OOP JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
