import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;

public class AddTransactionWindow {

    public static void display(BudgetManager manager) {
        Stage window = new Stage();
        window.setTitle("Add Transaction");

        // Fields
        TextField amountField = new TextField();
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("income", "expense");

        TextField categoryField = new TextField();
        TextArea descriptionArea = new TextArea();

        Button saveButton = new Button("Save");
        Label statusLabel = new Label();
        Button backButton = new Button("Back to Main Menu");

        backButton.setOnAction(e -> window.close());  // Back button simply closes this window

        // Layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(8);
        layout.setHgap(10);

        layout.add(new Label("Amount:"), 0, 0);
        layout.add(amountField, 1, 0);

        layout.add(new Label("Type:"), 0, 1);
        layout.add(typeBox, 1, 1);

        layout.add(new Label("Category:"), 0, 2);
        layout.add(categoryField, 1, 2);

        layout.add(new Label("Description:"), 0, 3);
        layout.add(descriptionArea, 1, 3);

        layout.add(saveButton, 1, 4);
        layout.add(statusLabel, 1, 5);
        layout.add(backButton, 1, 6);  // New back button

        // Save Button Event
        saveButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String type = typeBox.getValue();
                String category = categoryField.getText();
                String description = descriptionArea.getText();

                if (type == null || category.isEmpty()) {
                    throw new IllegalArgumentException("Type and category are required.");
                }

                Transaction t = new Transaction(amount, category, description, LocalDate.now(), type);
                manager.addTransaction(t);

                statusLabel.setText("Transaction saved.");
                amountField.clear();
                typeBox.setValue(null);
                categoryField.clear();
                descriptionArea.clear();
            } catch (Exception ex) {
                statusLabel.setText("Error: " + ex.getMessage());
            }
        });

        Scene scene = new Scene(layout, 400, 350);
        window.setScene(scene);
        window.show();
    }
}

