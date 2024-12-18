package data.accounts;

public class Saving extends Account {


    public Saving(String accountNumber, AccountType accountType) {
        super(accountNumber, accountType);
    }
    public void deductFees(){
        withdraw(AccountType.SAVINGS.getFees());
        System.out.println("Deducted Fees of " + AccountType.SAVINGS.getFees());
    }
    public double getInterestRates(){
        return AccountType.SAVINGS.getInterestRates();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Deposited to saving account: " + amount);
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
