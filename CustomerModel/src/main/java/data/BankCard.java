package data;

public class BankCard {
    private String cardNumber;
    private Account linkedAccount;

    // Constructor for BankCard class
    public BankCard(String cardNumber, Account linkedAccount) {
        this.cardNumber = cardNumber;
        this.linkedAccount = linkedAccount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Getter for card number
    public String getCardNumber() {
        return cardNumber;
    }

    // Method to withdraw money from the linked account (only if it's a checking account)
    public void withdraw(double amount) {
        if (linkedAccount != null && linkedAccount.getAccountType() == Account.AccountType.CHECKING) {
            if (amount > 0 && linkedAccount.getBalance() >= amount) {
                linkedAccount.withdraw(amount);
                System.out.println("Withdrawal of " + amount + " from checking account was successful.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Withdrawals are only allowed from a checking account.");
        }
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", linkedAccount=" + linkedAccount +
                '}';
    }
}
