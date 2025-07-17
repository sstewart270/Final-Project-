import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BudgetTrackerApp extends Application {

    private BudgetManager budgetManager = new BudgetManager();

    public static void main(String[] args) {
        launch(args);  // Starts JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Budget Tracker");

        // Main Menu Buttons
        Button addTransactionButton = new Button("Add Transaction");
        Button viewSummaryButton = new Button("View Summary");
        Button exitButton = new Button("Exit");

        // Button Actions
        addTransactionButton.setOnAction(e -> showAddTransactionWindow());
        viewSummaryButton.setOnAction(e -> showSummaryWindow());
        exitButton.setOnAction(e -> primaryStage.close());

        // Layout for Main Menu
        VBox layout = new VBox(10);
        layout.setSpacing(15);
        layout.getChildren().addAll(addTransactionButton, viewSummaryButton, exitButton);

        // Main Scene Setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddTransactionWindow() {
        AddTransactionWindow.display(budgetManager);
    }

    private void showSummaryWindow() {
        SummaryWindow.display(budgetManager);
    }
}

