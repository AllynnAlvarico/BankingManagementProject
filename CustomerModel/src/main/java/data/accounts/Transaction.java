package data.accounts;

import java.time.LocalDateTime;

public class Transaction {
    private final String transactionId;
    private final String accountNumber;
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime dateTime;
    private final String description;

    public Transaction(String transactionId, String accountNumber, TransactionType type, double amount, String description) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
