package data.customer;

import data.adt.AddressADT;

public class Address implements AddressADT {
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String state;
    private String zipcode;

    public Address(){

    }
    public Address(String addressLine1, String addressLine2, String town, String state, String zipcode) {
        setFullAddress(addressLine1, addressLine2, town, state, zipcode);
    }
    @Deprecated // uses of Deprecated is flagging a dev that this method is either old or not used I think
    public void setFullAddress(String addressLine1, String addressLine2, String town, String state, String zipcode){
        // This feels Redundant but will keep the method for future use maybe
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setTown(town);
        setState(state);
        setZipcode(zipcode);
    }

    @Override
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Override
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
    public String getAddressLine1() {
        return addressLine1;
    }

    @Override
    public String getAddressLine2() {
        return addressLine2;
    }

    @Override
    public String getTown() {
        return town;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getZipcode() {
        return zipcode;
    }

    @Override
    public String getFullAddress() {
        return addressLine1 + " " + addressLine2 + ", " + town + ", " + state + " " + zipcode;
    }
    @Override
    public String toString() {
        return getFullAddress();
    }
}

