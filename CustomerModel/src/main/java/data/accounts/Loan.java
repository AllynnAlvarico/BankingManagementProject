package data.accounts;

public class Loan extends Account{
    private double principalLoanAmount;
    private double loanAmount;
    public Loan(String accountNumber, AccountType accountType) {
        super(accountNumber, accountType);
    }

    public void deductFees(){
        withdraw(AccountType.BUSINESS.getFees());
        System.out.println("Deducted Fees of " + AccountType.SAVINGS.getFees());
    }
   public void loanAmountInterest(int byVal_months, double byVal_monthlyInterest){
       loanAmount = principalLoanAmount * byVal_monthlyInterest * byVal_months;
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
