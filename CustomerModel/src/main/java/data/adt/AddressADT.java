package data.adt;

public interface AddressADT {


    public void setAddressLine1(String addressLine1);

    public void setAddressLine2(String addressLine2);

    public void setTown(String town);

    public void setState(String state);

    public void setZipcode(String zipcode);

    public String getAddressLine1();
    public String getAddressLine2();

    public String getTown();

    public String getState();

    public String getZipcode();

    // A method to return the full address as a string
    public String getFullAddress();

    @Override
    public String toString();

}
