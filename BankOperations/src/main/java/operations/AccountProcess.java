package operations;

import data.CustomerInformation;
public class AccountProcess {
    private CustomerInformation accountUser;

    public void createUserAccount(String byVal_name, String byVal_surname, String byVal_username, String byVal_password){
        accountUser = new CustomerInformation(byVal_name, byVal_surname, byVal_username, byVal_password);
        accountUser.setAccountNumber();
        accountUser.setCardPin();
        accountUser.setBalance();
    }
    public void setCustomerAddress(String byVal_address1, String byVal_address2, String byVal_town, String byVal_state, String byVal_zipcode){
        accountUser.setAddress1(byVal_address1);
        accountUser.setAddress2(byVal_address2);
        accountUser.setTown(byVal_town);
        accountUser.setState(byVal_state);
        accountUser.setZipcode(byVal_zipcode);
    }
    public void setAccountUserContact(String byVal_phoneNumber, String byVal_email){
        accountUser.setPhoneNumber(byVal_phoneNumber);
        accountUser.setEmail(byVal_email);
    }
    public void setAccountOther(String byVal_passport){
        accountUser.setPassportInformation(byVal_passport);
        accountUser.setAccountUniqueId();
    }

    public CustomerInformation getAccountUser() {
        return accountUser;
    }
}
