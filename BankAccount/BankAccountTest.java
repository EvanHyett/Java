
public class BankAccountTest {
    public static void main(String[] args){

        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.deposit("savings", 1000.00);
        account1.deposit("checking", 500.00);
        account2.deposit("checking", 420.00);
        account2.deposit("savings", 6000.00);
        account1.withdrawal("checking", 100.00);
        account2.withdrawal("savings", 70000.00);
        account1.totalBalance();
        account2.totalBalance();
    }
}
