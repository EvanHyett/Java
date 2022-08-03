
public class BankAccount {

    // Attributes
    private double checkingBalance = 0.0;
    private double savingsBalance = 0.0;
    public static int numberOfAccounts = 0;
    public static double totalMoneyAmount = 0.0;

    // Constructor
    public BankAccount() {
        // double checkingBalance = 0.0;
		// double savingsBalance = 0.0;
		numberOfAccounts++;	
    }

    // Getters
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Setters
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // Methods
    public void deposit(String accountType, double depositAmount) {
        if (accountType == "checking") {
            setCheckingBalance(getCheckingBalance() + depositAmount);
            totalMoneyAmount += depositAmount;
        }
        if (accountType == "savings") {
            setSavingsBalance(getSavingsBalance() + depositAmount);
            totalMoneyAmount += depositAmount;
        }
    }

    public void withdrawal(String accountType, double withdrawalAmount) {
        if (accountType == "checking") {
            if (getCheckingBalance() < withdrawalAmount) {
                System.out.println("Insufficient Funds!");
            }
            else {
                setCheckingBalance(getCheckingBalance() - withdrawalAmount);
                totalMoneyAmount -= withdrawalAmount;
            }
        }
        if (accountType == "savings") {
            if (getSavingsBalance() < withdrawalAmount) {
                System.out.println("Insufficient Funds!");
            }
            else {
                setSavingsBalance(getSavingsBalance() - withdrawalAmount);
                totalMoneyAmount -= withdrawalAmount;
            }
        }
    }

    public double totalBalance() {
        double balance = checkingBalance + savingsBalance;
        System.out.println(balance);
        return balance;
    }
}
