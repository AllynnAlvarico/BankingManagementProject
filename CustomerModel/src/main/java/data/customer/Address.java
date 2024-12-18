package data.customer;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String state;
    private String zipcode;

    // Constructor to initialize all fields
    public Address(String addressLine1, String addressLine2, String town, String state, String zipcode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Getter and Setter methods
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // A method to return the full address as a string
    public String getFullAddress() {
        return addressLine1 + " " + addressLine2 + ", " + town + ", " + state + " " + zipcode;
    }

    @Override
    public String toString() {
        return getFullAddress();
    }
}

