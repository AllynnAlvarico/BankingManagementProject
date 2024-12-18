package data.customer;

import data.accounts.BankCard;
import data.accounts.Account;
import operations.AccountType;
import operations.CategoryType;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {

    private String customerId;
    private String email;
    private String phoneNumber;
    private final Map<String, Account> accounts;
    private BankCard bankCard;

    public Customer(
            String byVal_firstname, String byVal_lastname, String byVal_dateOfBirth,
            String nationality, Address byVal_address, String byVal_gender, byte byVal_age,
            String byVal_email, String byVal_phoneNumber) {

        super(byVal_firstname, byVal_lastname, byVal_dateOfBirth, nationality, byVal_address, byVal_gender, byVal_age);
        this.email = byVal_email;
        this.phoneNumber = byVal_phoneNumber;
        this.accounts = new HashMap<>();
    }

    public void setCustomerId(String customerId) {
        this.customerId = "00" + customerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountType(AccountType accountType) {
    }

    public void setCategory(CategoryType categoryType) {
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addAccount(Account account) {
        // Add the account to the map, using account number as the key
        // And be able to store the account details
        accounts.put(account.getAccountNumber(), account);

    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public Map<String, Account> getAccounts() {
        // This method gets the list of the Accounts opened by the user
        // Users are allowed to have multiple accounts under 1 customer
        // Hence the Map Collection for implementation.
        return accounts;
    }
    public Account getAccountByNumber(String accountNumber) {
        // Get account by account number (key)
        // which is the Account number so if retrieving a specific account
        // use the getAccountNumber on Customer Class
        return accounts.get(accountNumber);
    }

    public Account getCheckingAccount(Account byRef_accountNumber){
        return accounts.get(byRef_accountNumber.getCheckingAccountNumber());
    }
    public double getTotalAccountValue(){
        return accounts.values().stream()
                .filter(b -> b.getBalance() > 0)
                .mapToDouble(Account::getBalance)
                .sum();
    }
    public int getTotalAccount(){
        return accounts.size();
    }
    @Override
    public String toString() {
        return "Customer Information{" +
                "\nCustomer Id = '" + customerId + '\'' +
                "\n==================================================================="+
                "\n" + super.toString() +
                "\nemail='" + email + '\'' +
                "\nphoneNumber='" + phoneNumber + '\'' +
                "\n===================================================================\n" +
                "\nCustomer Accounts\n" +
                formattedString() +
                "\naddress=" + getAddress() +
                '}';
    }
    public String formattedString(){
        StringBuilder accountNumbers = new StringBuilder("Account Numbers:\n");
        accountNumbers.append("Account ID  |    Account Number    |   Account Type   |  Balance  |\n");
        accountNumbers.append("===================================================================\n");

        for (Account accountNumber : accounts.values()) {
            accountNumbers.append("|    ").append(accountNumber.getAccountId()).append("    |   ").
                    append(accountNumber.getAccountNumber()).append("  | ").
                    append(accountNumber.getAccountType().toString()).append(" |    ").
                    append(accountNumber.getBalance()).append("    | ");
            accountNumbers.append("\n-------------------------------------------------------------------\n");
        }
        return accountNumbers.toString();
    }

}
