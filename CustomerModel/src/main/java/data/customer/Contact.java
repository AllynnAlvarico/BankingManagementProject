package data.customer;

import data.adt.ContactADT;

/**
 * Author: Allynn Alvarico
 * Created: 19/12/2024 4 am
 */

public class Contact implements ContactADT {
    private String email;
    private String phoneNumber;

    public Contact(){}

    public Contact(String email, String phoneNumber){
        setEmail(email);
        setPhoneNumber(phoneNumber);
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
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
