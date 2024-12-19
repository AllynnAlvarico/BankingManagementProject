package data.customer;

import data.accounts.*;
import data.adt.CustomerADT;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class(Sub class) inherits from Person Class
 * ***Purpose*** of this class is to be a Base DTOs - Data Transfer Objects.
 * Hold Data Objects about the customer which will have
 * Author: Allynn Alvarico
 *
 * Last Modified: 19/12/2024 4.30 am
 *
 * Class has 1 constructor
 * Person(String, String)
 *
 * Methods are:
 * =======================Setters=======================
 * -setCustomerID();
 * -setAddress();
 * -setBankCard();
 * -setContact();
 * =======================Getters=======================
 * -getCustomerID();
 * -getAddress();
 * -getBankCard();
 * -getContact();
 * -getAccounts();
 * -getTotalAccount();
 * -getTotalAccountValue();
 * ====================Other Methods====================
 * -addAccount();
 * -getCheckingAccount();
 * -getAccountByNumber();
 * -toString();
 * -formattedString();
 *
 */

public class Customer extends Person implements CustomerADT {

    private String customerId;
    private Address address;
    private BankCard bankCard;
    private Contact contact;
    private Map<String, Account> accounts;
    public Customer() {
        super();
    }
    public Customer(String firstname, String lastname){
        super(firstname, lastname);
        setAddress(new Address());
        setContact(new Contact());
        this.accounts = new HashMap<>();
    }

    @Override
    public void setCustomerID(String id) {
        this.customerId = "00" + customerId;
    }

    @Override
    public void setAddress(Address a) {
        this.address = a;
    }

    @Override
    public void setBankCard(BankCard b) {
        this.bankCard = b;
    }

    @Override
    public void setContact(Contact c) {
        this.contact = c;
    }

    @Override
    public String getCustomerID() {
        return this.customerId;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public BankCard getBankCard() {
        return this.bankCard;
    }

    @Override
    public Contact getContact() {
        return this.contact;
    }

    @Override
    public Map<String, Account> getAccounts() {
        // This method gets the list of the Accounts opened by the user
        // Users are allowed to have multiple accounts under 1 customer
        // Hence the Map Collection for implementation.
        return this.accounts;
    }

    @Override
    public int getTotalAccount() {
        // This will return how many accounts does the customer has under them.
        return accounts.size();
    }

    @Override
    public double getTotalAccountValue(){
        // This sums all the money or balance on the customers account.
        return accounts.values().stream()
                .filter(b -> b.getBalance() > 0)
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public void addAccount(Account a) {
        // Add the account to the map, using account number as the key
        // And be able to store the account details
        accounts.put(a.getAccountNumber(), a);
    }

    @Override
    public Account getCheckingAccount(Account byRef_accountNumber) {
        return accounts.get(byRef_accountNumber.getCheckingAccountNumber());
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        // Get account by account number (key)
        // which is the Account number so if retrieving a specific account
        // use the getAccountNumber on Customer Class
        return accounts.get(accountNumber);
    }

    @Override
    public String toString() {
        return "Customer Information{" +
                "\nCustomer Id = '" + customerId + '\'' +
                "\n==================================================================="+
                "\n" + super.toString() +
                "\nemail='" + contact.getEmail() + '\'' +
                "\nphoneNumber='" + contact.getPhoneNumber() + '\'' +
                "\n===================================================================\n" +
                "\nCustomer Accounts\n" +
                formattedString() +
                "\naddress=" + address.getFullAddress() +
                '}';
    }

    @Override
    public String formattedString() {

        // This Method is only for Terminal use for visualising the data object into a table
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
