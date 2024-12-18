package data.accounts;

public class Account {
    private static int accountTotal;
    private String accountId;
    private String accountNumber;
    private String checkingAccountNumber;

    private AccountType  accountType;
    private double balance;

    public enum AccountType{
        CHECKING("Checking Account", 0.011, 10),
        SAVINGS("Savings Account", 0.0315, 5),
        BUSINESS("Business Account", 0.01, 25);
        private final String accountType;
        private final double interestRates;
        private final double fees;

        AccountType(String byVal_account, double byVal_interestRates, double byVal_fees) {
            accountType = byVal_account;
            interestRates = byVal_interestRates;
            fees = byVal_fees;
        }
        public double getInterestRates() {
            return interestRates;
        }

        public double getFees() {
            return fees;
        }

        public String toString() {
            return accountType;
        }
    }
    static {
        accountTotal += 0;
    }
    public Account(String accountNumber, AccountType accountType) {
        accountTotal += 1;
        setAccountId();
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0d;
    }

    public void setAccountId() {
        this.accountId = "00" + accountTotal;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCheckingAccountNumber(String checkingAccountNumber) {
        this.checkingAccountNumber = checkingAccountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getCheckingAccountNumber() {
        return checkingAccountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        // Bug here! How will the system know which to deposit the amount???
        // need to find a solution for this.
        // Same issue for the withdraw method but the method on bankcard class is working
        // as user are only allowed to withdraw money from their checking account.
        // 18/12/2024 3:28am

        // had a solution. make a subclass so that it is able to differentiate the accounts
        // 3:49am
        if (amount > 0) {
            this.balance += amount;
//            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
//            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static int getAccountTotal() {
        return accountTotal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "\nAccount ID='" + accountId + '\'' +
                "\naccountNumber='" + accountNumber + '\'' +
                "\naccountType='" + accountType + '\'' +
                "\nbalance=" + balance;}
}
