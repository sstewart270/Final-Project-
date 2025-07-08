import java.time.LocalDate;

public class TestTransaction {
    public static void main(String[] args) {
        Transaction t1 = new Transaction(150.00, "Groceries", "Weekly shopping", LocalDate.now(), "expense");
        Transaction t2 = new Transaction(2000.00, "Salary", "Monthly paycheck", LocalDate.now(), "income");

        System.out.println(t1);
        System.out.println(t2);
    }
}
