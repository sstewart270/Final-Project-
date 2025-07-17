import java.time.LocalDate;

public class Transaction {

    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private String type;  // "income" or "expense"

    public Transaction(double amount, String category, String description, LocalDate date, String type) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.type = type;
    }

    // Getter Methods (needed for TableView)
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    // Optional setters (if needed)
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
            "Transaction[%s | $%.2f | %s | %s | %s]",
            type, amount, category, description, date
        );
    }
}

