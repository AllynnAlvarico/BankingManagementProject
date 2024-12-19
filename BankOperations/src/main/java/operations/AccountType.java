package operations;

public enum AccountType{

    CHECKING ("Checking Account"),
    SAVING ("Savings Account"),
    BUSINESS ("Business Account");
    private String typeAccount;
    private String getTypeAccount(){return typeAccount;}

    AccountType(String s) {
        typeAccount = s;
    }

    @Override
    public String toString() {
        return getTypeAccount();
    }
}
