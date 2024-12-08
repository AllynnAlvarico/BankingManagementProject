package data;

import util.DataUtilities;

public class CustomerInformation implements ActorADT, PersonalInformationADT, AccountInformationADT {

    private static int customerID;
    private static int totalCustomer;
    private DataUtilities utilities;
    private String generatedCustomerId;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String addressOne;
    private String addressTwo;
    private String town;
    private String state;
    private String zipcode;
    private String email;
    private String phoneNumber;
    private String passportNumber;
    private String accountId;
    private String accountNumber;
    private short pinCard;
    private String accountType;
    private CardInformation cardInformation;
    private String tierLevel;
    private double balance;

    static {
        totalCustomer += 1;
        customerID += 1;
    }
    private CustomerInformation(){
        generatedCustomerId = "00" + customerID;
//        utilities = new DataUtilities();
    }

    public CustomerInformation(String byVal_name, String byVal_surname, String byVal_username, String byVal_password){
        new CustomerInformation();
        this.name = byVal_name;
        this.surname = byVal_surname;
        this.username = byVal_username;
        this.password = byVal_password;
    }
    @Override
    public void setName(String byVal_name) {
        this.name = byVal_name;
    }

    @Override
    public void setSurname(String byVal_surname) {
        this.surname = byVal_surname;
    }

    @Override
    public void setUsername(String byVal_username) {
        this.username = byVal_username;
    }

    @Override
    public void setPassword(String byVal_password) {
        this.password = byVal_password;
    }

    @Override
    public String getName() {
        return utilities.capitalise(name);
    }

    @Override
    public String getSurname() {
        return utilities.capitalise(surname);
    }

    @Override
    public String getFullName() {
        String fullname = name + " " + surname;
        return utilities.capitalise(fullname);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getCustomerId() {
        return generatedCustomerId;
    }

    @Override
    public Boolean hasValidInformation(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public static int getTotalCustomer() {
        return totalCustomer;
    }

    @Override
    public void setAddress1(String address1) {
        this.addressOne = address1;
    }

    @Override
    public void setAddress2(String address2) {
        this.addressTwo = address2;
    }

    @Override
    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setPassportInformation(String passportInformation) {
        this.passportNumber = passportInformation;
    }

    @Override
    public String getFullAddress() {
        String fullAddress = addressOne + " " + addressTwo;
        return utilities.capitalise(fullAddress);
    }

    @Override
    public String getTown() {
        return utilities.capitalise(this.town);
    }

    @Override
    public String getState() {
        return utilities.capitalise(this.state);
    }

    @Override
    public String getZipcode() {
        return this.zipcode.toUpperCase().trim();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getPassportNumber() {
        return this.passportNumber.toUpperCase();
    }

    @Override
    public void setAccountUniqueId() {
        int index = 0;
        index += 1;
        this.accountId = "00" + index;
    }

    @Override
    public void setAccountNumber() {
        this.accountId = utilities.generateAccountNumber();
    }

    @Override
    public void setCardPin() {
        this.pinCard = (short) utilities.generatePin();
    }

    @Override
    public void changePin(short newPin) {
        pinCard = newPin;
    }

    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public void setCardNumber() {
        cardInformation = new CardInformation(utilities.generateCardNumber());
    }

    @Override
    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    @Override
    public void setBalance() {
        this.balance = 0.0d;
    }

    @Override
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public String getAccountId() {
        return this.accountId;
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public short getPin() {
        return this.pinCard;
    }

    @Override
    public String getAccountType() {
        return this.accountType;
    }

    @Override
    public String getCard() {
        return this.cardInformation.cardNumber();
    }

    @Override
    public String getTierLevel() {
        return this.tierLevel;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
