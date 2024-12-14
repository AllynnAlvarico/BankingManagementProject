package data;

public interface AccountInformationADT {
    public void setAccountUniqueId();
    public void setAccountNumber();
    public void setCardPin();
    public void changePin(short newPin);
    public void setAccountType(String accountType);
    public void setCardNumber();
    public void setCategory(String category);
    public void setBalance();
    public void setBalance(String newBalance);
    public String getAccountId();
    public String getAccountNumber();
    public short getPin();
    public String getAccountType();
    public String getCard();
    public String getCategory();
    public double getBalance();
}
