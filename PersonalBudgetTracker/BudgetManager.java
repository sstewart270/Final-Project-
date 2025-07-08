import java.util.ArrayList;

public class BudgetManager {
    private ArrayList<Transaction> transactions;
    private User user;

    public BudgetManager() {
        transactions = new ArrayList<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addTransaction(Transaction t) {
        if (t != null) {
            transactions.add(t);
        }
    }

    public ArrayList<Transaction> getAllTransactions() {
        return transactions;
    }

    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> t.getType().equals("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
                .filter(t -> t.getType().equals("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpenses();
    }

    @Override
    public String toString() {
        return String.format("Budget Summary for %s:\nTotal Income: $%.2f\nTotal Expenses: $%.2f\nBalance: $%.2f",
                user != null ? user.getFirstName() + " " + user.getLastName() : "Unknown User",
                getTotalIncome(), getTotalExpenses(), getBalance());
    }
}
