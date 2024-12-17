package operations;

import data.Address;
import data.Customer;
import data.Gender;

public class AccountProcess {
    private Customer accountUser;
    // Test Description for the Category
    private String descriptionCategory;

    public void createUserAccount(
            String byVal_name, String byVal_surname, String byVal_dob, String byVal_nationality,
            String byVal_address1, String byVal_address2, String byVal_town, String byVal_state, String byVal_zipcode,
            Gender byVal_gender, byte byVal_age, String byVal_email, String byVal_phone)
    {
        accountUser = new Customer(
                byVal_name, byVal_surname, byVal_dob, byVal_nationality,
                new Address(byVal_address1, byVal_address2, byVal_town, byVal_state, byVal_zipcode),
                byVal_gender.name(), byVal_age, byVal_email, byVal_phone);
        // Default to Checking account and Personal category
        accountUser.setAccountType(AccountType.CHECKING);
        accountUser.setCategory(CategoryType.PERSONAL);
        descriptionCategory = CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.name());

//        accountUser = new CustomerInformation(byVal_name, byVal_surname, byVal_username, byVal_password);
//        accountUser.setAccountNumber();
//        accountUser.setCardNumber();
//        accountUser.setCardPin();
//        accountUser.setBalance();
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
//
    public void setAccountType(int byVal_selectedAccountType) {
        switch (byVal_selectedAccountType) {
            case 1 -> accountUser.setAccountType(AccountType.BUSINESS);
            case 2 -> accountUser.setAccountType(AccountType.SAVING);
            default -> accountUser.setAccountType(AccountType.CHECKING);
        }
    }
    public void setCategoryType(int byVal_selectedType){
        switch (byVal_selectedType) {
            case 1:
                accountUser.setCategory(CategoryType.YOUTH);
                descriptionCategory = CategoryType.YOUTH.getDescription(CategoryType.YOUTH.toString());
                break;
            case 2 :
                accountUser.setCategory(CategoryType.STUDENT);
                descriptionCategory = CategoryType.STUDENT.getDescription(CategoryType.STUDENT.toString());
                break;
            case 3:
                accountUser.setCategory(CategoryType.SENIOR_CITIZEN);
                descriptionCategory = CategoryType.SENIOR_CITIZEN.getDescription(CategoryType.SENIOR_CITIZEN.toString());
                break;
            case 4:
                accountUser.setCategory(CategoryType.BUSINESS);
                descriptionCategory = CategoryType.BUSINESS.getDescription(CategoryType.BUSINESS.toString());
                break;
            case 5:
                accountUser.setCategory(CategoryType.PREMIUM);
                descriptionCategory = CategoryType.PREMIUM.getDescription(CategoryType.PREMIUM.toString());
                break;
            case 6:
                accountUser.setCategory(CategoryType.BLACKLISTED);
                descriptionCategory = CategoryType.BLACKLISTED.getDescription(CategoryType.BLACKLISTED.toString());
                break;
            default:
                accountUser.setCategory(CategoryType.PERSONAL);
                descriptionCategory = CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.toString());
                break;
        }
    }

    //Test getter Method for Category Descriptions
    public String getDescriptionCategory(){
        return descriptionCategory;
    }

    public Customer getAccountUser() {
        return accountUser;
    }
}
