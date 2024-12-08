package data;

public interface PersonalInformationADT {

    public void setAddress1(String address1);
    public void setAddress2(String address2);
    public void setTown(String town);
    public void setState(String state);
    public void setZipcode(String zipcode);
    public void setEmail(String email);
    public void setPhoneNumber(String phoneNumber);
    public void setPassportInformation(String passportInformation);
    public String getFullAddress();
    public String getTown();
    public String getState();
    public String getZipcode();
    public String getEmail();
    public String getPhoneNumber();
    public String getPassportNumber();



}
