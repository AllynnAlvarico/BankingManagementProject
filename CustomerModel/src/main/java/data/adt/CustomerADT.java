package data.adt;

import data.accounts.Account;
import data.accounts.BankCard;
import data.customer.Address;
import data.customer.Contact;

import java.util.Map;


/**
 * Author: Allynn ALvarico
 * Created: 19/12/2024 4.25 am
 */
public interface CustomerADT {

    //Setters
    public void setCustomerID(String id);
    public void setAddress(Address a);
    public void setBankCard(BankCard b);
    public void setContact(Contact c);

    //Getters
    public String getCustomerID();
    public Address getAddress();
    public BankCard getBankCard();
    public Contact getContact();
    public Map<String, Account> getAccounts();
    public int getTotalAccount();
    public double getTotalAccountValue();

    //Other Methods
    public void addAccount(Account a);
    public Account getCheckingAccount(Account byRef_accountNumber);
    public Account getAccountByNumber(String accountNumber);
    public String toString();
    public String formattedString();
}
