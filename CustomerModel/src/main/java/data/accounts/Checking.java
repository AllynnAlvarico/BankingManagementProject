package data.accounts;

public class Checking extends Account{
    public Checking(String accountNumber, AccountType accountType) {
        super(accountNumber, accountType);
    }
    public void deductFees(){
        withdraw(AccountType.BUSINESS.getFees());
        System.out.println("Deducted Fees of " + AccountType.SAVINGS.getFees());
    }
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Deposited to Business Account: " + amount);
    }
    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }
}
