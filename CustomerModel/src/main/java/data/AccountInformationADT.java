package data;

public interface AccountInformationADT {
    public void setAccountUniqueId();
    public void setAccountNumber();
    public void setCardPin();
    public void changePin(short newPin);
    public void setAccountType(String accountType);
    public void setCardNumber();
    public void setTierLevel(String tierLevel);
    public void setBalance();
    public void setBalance(double newBalance);
    public String getAccountId();
    public String getAccountNumber();
    public short getPin();
    public String getAccountType();
    public String getCard();
    public String getTierLevel();
    public double getBalance();
}
