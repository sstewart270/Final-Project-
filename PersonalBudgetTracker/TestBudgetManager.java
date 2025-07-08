import java.time.LocalDate;

public class TestBudgetManager {
    public static void main(String[] args) {
        User u = new User("Samuel", "Stewart", "user123", 1500.00);

        BudgetManager manager = new BudgetManager();
        manager.setUser(u);

        manager.addTransaction(new Transaction(1000.00, "Salary", "Paycheck", LocalDate.now(), "income"));
        manager.addTransaction(new Transaction(300.00, "Rent", "Monthly rent", LocalDate.now(), "expense"));
        manager.addTransaction(new Transaction(200.00, "Food", "Dining out", LocalDate.now(), "expense"));

        System.out.println(manager);
    }
}
