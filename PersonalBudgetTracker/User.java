public class User {
    private String firstName;
    private String lastName;
    private String userID;
    private double monthlyBudgetGoal;

    public User() {}

    public User(String firstName, String lastName, String userID, double monthlyBudgetGoal) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserID(userID);
        setMonthlyBudgetGoal(monthlyBudgetGoal);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        if (userID != null && !userID.isEmpty()) {
            this.userID = userID;
        } else {
            throw new IllegalArgumentException("User ID cannot be empty.");
        }
    }

    public double getMonthlyBudgetGoal() {
        return monthlyBudgetGoal;
    }

    public void setMonthlyBudgetGoal(double monthlyBudgetGoal) {
        if (monthlyBudgetGoal >= 0) {
            this.monthlyBudgetGoal = monthlyBudgetGoal;
        } else {
            throw new IllegalArgumentException("Budget goal must be non-negative.");
        }
    }

    @Override
    public String toString() {
        return String.format("User[%s %s | ID: %s | Budget Goal: $%.2f]",
                firstName, lastName, userID, monthlyBudgetGoal);
    }
}
