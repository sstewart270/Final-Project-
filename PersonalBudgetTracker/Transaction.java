import java.time.LocalDate;

public class Transaction {
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private String type; // "income" or "expense"

    public Transaction() {}

    public Transaction(double amount, String category, String description, LocalDate date, String type) {
        setAmount(amount);
        setCategory(category);
        setDescription(description);
        setDate(date);
        setType(type);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null && !category.isEmpty()) {
            this.category = category;
        } else {
            throw new IllegalArgumentException("Category cannot be empty.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description; // Optional field
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date != null ? date : LocalDate.now();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if ("income".equalsIgnoreCase(type) || "expense".equalsIgnoreCase(type)) {
            this.type = type.toLowerCase();
        } else {
            throw new IllegalArgumentException("Type must be 'income' or 'expense'.");
        }
    }

    @Override
    public String toString() {
        return String.format("Transaction[%s | $%.2f | %s | %s | %s]",
                type, amount, category, description, date);
    }
}
