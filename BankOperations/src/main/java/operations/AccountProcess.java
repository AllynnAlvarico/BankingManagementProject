package operations;

import data.accounts.*;
import data.customer.*;
import util.DataUtilities;

public class AccountProcess {
    private Customer customer;
    private Account account;
    private BankCard card;
    private String descriptionCategory;
    DataUtilities utilities = new DataUtilities();

    public void createUserAccount(
            String byVal_name, String byVal_surname, String byVal_dob, String byVal_nationality,
            String byVal_address1, String byVal_address2, String byVal_town, String byVal_state, String byVal_zipcode,
            Gender byVal_gender, byte byVal_age, String byVal_email, String byVal_phone)
    {
        customer = new Customer(
                byVal_name, byVal_surname, byVal_dob, byVal_nationality,
                new Address(byVal_address1, byVal_address2, byVal_town, byVal_state, byVal_zipcode),
                byVal_gender.name(), byVal_age, byVal_email, byVal_phone);

        customer.setCustomerId(Person.getPersonID().toString());

        createCheckingAccount();
        createSavingsAccount();
        createBusinessAccount();


        // testing for depositing and withdrawing to specific account...
        for (Account acc : customer.getAccounts().values()){
            if (acc instanceof Saving saving){
                saving.deposit(300_000);
                saving.withdraw(200_000);
                saving.deductFees();
            }
        }
        for (Account acc : customer.getAccounts().values()){
            if (acc instanceof Business business){
                business.deposit(100_000);
                business.withdraw(50_000);
                business.deductFees();
            }
        }


        account.deposit(100_010);

        setCustomerBankCard();
        card.withdraw(10_000);

        System.out.println("Card Number is " + card.getCardNumber());
        System.out.println("Checking Account Number is " +account.getCheckingAccountNumber());

        System.out.println("Total Amount of Customer Has in Account is " + getAccountUser().getTotalAccountValue());
//        account.withdraw(300);

//        customer.setCategory(CategoryType.PERSONAL);
//        descriptionCategory = CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.name());
    }
    public void createCheckingAccount(){
        String checkingAccountNumber = utilities.generateAccountNumber();
        account = new Checking(checkingAccountNumber, Account.AccountType.CHECKING);
        customer.addAccount(account);
        account.setCheckingAccountNumber(checkingAccountNumber);
    }
    public void createSavingsAccount(){
        customer.addAccount(new Saving(utilities.generateAccountNumber(), Account.AccountType.SAVINGS));
    }
    public void createBusinessAccount(){
        customer.addAccount(new Business(utilities.generateAccountNumber(), Account.AccountType.BUSINESS));
    }
    public void checkCustomerIfPremium(){
        if (customer.getTotalAccountValue() > 100_000) setCategoryType(5);
    }
    public void setCustomerBankCard(){
        card = new BankCard(utilities.generateCardNumber(),
                customer.getCheckingAccount(account));
        customer.setBankCard(card);
    }


//    public void createUserAccount(
//            String byVal_name, String byVal_surname, String byVal_username, String byVal_password,
//            String byVal_accountNumber, String byVal_cardNumber, String byVal_cardPin, String byVal_balance
//    ) {
//        accountUser = new CustomerInformation(byVal_name, byVal_surname, byVal_username, byVal_password);
//        accountUser.setAccountNumber(byVal_accountNumber);
//        accountUser.setCardNumber(byVal_cardNumber);
//        accountUser.setCardPin(byVal_cardPin);
//        accountUser.setBalance(byVal_balance);
//    }

//    public void setCustomerAddress(String byVal_address1, String byVal_address2, String byVal_town, String byVal_state, String byVal_zipcode) {
//        accountUser.setAddress1(byVal_address1);
//        accountUser.setAddress2(byVal_address2);
//        accountUser.setTown(byVal_town);
//        accountUser.setState(byVal_state);
//        accountUser.setZipcode(byVal_zipcode);
//    }
//
//    public void setAccountUserContact(String byVal_phoneNumber, String byVal_email) {
//        accountUser.setPhoneNumber(byVal_phoneNumber);
//        accountUser.setEmail(byVal_email);
//    }
//
//    public void setAccountOther(String byVal_passport) {
//        accountUser.setPassportInformation(byVal_passport);
//        accountUser.setAccountUniqueId();
//    }
    public void setCategoryType(int byVal_selectedType){
        switch (byVal_selectedType) {
            case 1:
                customer.setCategory(CategoryType.YOUTH);
                descriptionCategory = CategoryType.YOUTH.getDescription(CategoryType.YOUTH.toString());
                break;
            case 2 :
                customer.setCategory(CategoryType.STUDENT);
                descriptionCategory = CategoryType.STUDENT.getDescription(CategoryType.STUDENT.toString());
                break;
            case 3:
                customer.setCategory(CategoryType.SENIOR_CITIZEN);
                descriptionCategory = CategoryType.SENIOR_CITIZEN.getDescription(CategoryType.SENIOR_CITIZEN.toString());
                break;
            case 4:
                customer.setCategory(CategoryType.BUSINESS);
                descriptionCategory = CategoryType.BUSINESS.getDescription(CategoryType.BUSINESS.toString());
                break;
            case 5:
                customer.setCategory(CategoryType.PREMIUM);
                descriptionCategory = CategoryType.PREMIUM.getDescription(CategoryType.PREMIUM.toString());
                break;
            case 6:
                customer.setCategory(CategoryType.BLACKLISTED);
                descriptionCategory = CategoryType.BLACKLISTED.getDescription(CategoryType.BLACKLISTED.toString());
                break;
            default:
                customer.setCategory(CategoryType.PERSONAL);
                descriptionCategory = CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.toString());
                break;
        }
    }

    //Test getter Method for Category Descriptions
    public String getDescriptionCategory(){
        return descriptionCategory;
    }

    public Customer getAccountUser() {
        return customer;
    }
}
