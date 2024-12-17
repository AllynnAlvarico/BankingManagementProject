package data;


import util.DataUtilities;

public class Person {

    private final DataUtilities utilities;

    private static int personID;
    private static int totalPerson;


    private final String firstname;
    private final String lastname;
    private final String dateOfBirth;
    private final String nationality;
    private Address address;
    private final String gender;
    private byte age;

    static {
        totalPerson += 1;
        personID += 1;
    }
    public Person(
            String byVal_firstname, String byVal_lastname,
            String byVal_dateOfBirth, String nationality,
            Address byVal_address,
            String byVal_gender, byte byVal_age){
        utilities = new DataUtilities();

        if (byVal_firstname == null || byVal_firstname.isEmpty())
            throw new IllegalArgumentException("Firstname cannot be null or empty");

        this.firstname = byVal_firstname;
        this.lastname = byVal_lastname;
        this.dateOfBirth = byVal_dateOfBirth;
        this.nationality = nationality;
        this.address = byVal_address;
        this.gender = byVal_gender;
        this.age = byVal_age;
    }

    public static void setPersonID(int personID) {
        Person.personID = personID;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getFirstname () {
        return utilities.capitalise(firstname);
    }

    public String getLastname () {
        return utilities.capitalise(lastname);
    }

    public String getFullname () {
        return utilities.capitalise(firstname + " " + lastname);
    }

    public String formattedName() {
        return lastname.toUpperCase() + ", " + firstname;
    }

    public String getDateOfBirth () {
        return dateOfBirth;
    }

    public Byte getAge () {
        return age;
    }

    public String getNationality() {
        return utilities.capitalise(nationality);
    }
    public Address getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String greet() {
        return "Hello, " + getFullname() + ".";
    }

    public static Integer getPersonID() {
        return personID;
    }

    public static Integer getTotalPerson() {
        return totalPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                ", address=" + address.getFullAddress() +
                '}';
    }
}

