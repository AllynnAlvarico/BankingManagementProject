package data;

import operations.AccountType;
import operations.CategoryType;

import java.util.HashMap;
import java.util.Map;

public class Customer extends Person {

    private String customerId;
    private String accountId;
    private String email;
    private String phoneNumber;
    private final Map<String, Account> accounts;

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

    public void setAccountId(String accountId) {
        this.accountId = "000" + accountId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);  // Add the account to the map, using account number as the key
    }

    // Method to get all accounts
    public Map<String, Account> getAccounts() {
        return accounts;
    }

    // Method to get an account by account number
    public Account getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);  // Get account by account number (key)
    }

    @Override
    public String toString() {
        return "CustomerInformation{" +
                "customerId='" + customerId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accounts=" + accounts +
                ", address=" + getAddress() +
                '}';
    }

    public void setAccountType(AccountType accountType) {
    }

    public void setCategory(CategoryType categoryType) {
    }
}
