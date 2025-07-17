import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryWindow {

    public static void display(BudgetManager manager) {
        Stage window = new Stage();
        window.setTitle("Summary");

        double income = manager.getTotalIncome();
        double expenses = manager.getTotalExpenses();
        double balance = manager.getBalance();

        Label incomeLabel = new Label("Total Income: $" + String.format("%.2f", income));
        Label expenseLabel = new Label("Total Expenses: $" + String.format("%.2f", expenses));
        Label balanceLabel = new Label("Current Balance: $" + String.format("%.2f", balance));

        // Filter Income Transactions
        List<Transaction> incomeTransactions = manager.getAllTransactions().stream()
                .filter(t -> t.getType().equalsIgnoreCase("income"))
                .collect(Collectors.toList());

        // Filter Expense Transactions
        List<Transaction> expenseTransactions = manager.getAllTransactions().stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .collect(Collectors.toList());

        // Create two separate TableViews
        Label incomeTableLabel = new Label("Income Transactions:");
        TableView<Transaction> incomeTable = createTransactionTable(incomeTransactions);

        Label expenseTableLabel = new Label("Expense Transactions:");
        TableView<Transaction> expenseTable = createTransactionTable(expenseTransactions);

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
                incomeLabel,
                expenseLabel,
                balanceLabel,
                new Separator(),
                incomeTableLabel,
                incomeTable,
                new Separator(),
                expenseTableLabel,
                expenseTable,
                backButton
        );

        Scene scene = new Scene(layout, 800, 700);
        window.setScene(scene);
        window.show();
    }

    // Helper method to create a TableView for a list of transactions
    private static TableView<Transaction> createTransactionTable(List<Transaction> transactions) {
        TableView<Transaction> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Transaction, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(data -> new SimpleStringProperty(
                "$" + String.format("%.2f", data.getValue().getAmount())
        ));

        TableColumn<Transaction, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));

        TableColumn<Transaction, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Transaction, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        ));

        table.getColumns().addAll(amountColumn, categoryColumn, descriptionColumn, dateColumn);

        ObservableList<Transaction> observableTransactions = FXCollections.observableArrayList(transactions);
        table.setItems(observableTransactions);

        return table;
    }
}








