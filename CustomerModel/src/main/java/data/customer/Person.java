package data.customer;

import util.DataUtilities;

/**
 * This Class is a Base Class or Super Class that will be inherited by Customer Class and Staff Class
 * ***Purpose*** of this class is to be a Base DTOs - Data Transfer Objects.
 * Learned Terminology (DTOs - Data Transfer Objects)
 * Author: Allynn Alvarico
 *
 * Last Modified: 19/12/2024 3.09 am
 *
 * Class has 3 constructor
 * Person(), Person(String, String), Person(String, String, String, byte)
 *
 * Methods are:
 * ==Setters==
 * -setNames();
 * -setPersonID();
 * -setFirstname();
 * -setLastname();
 * -setDateOfBirth();
 * -setAge();
 * ==Getters==
 * -getPersonID();
 * -getFirstname();
 * -getLastname();
 * -getFullname();
 * -getFormattedName();
 * -getDateOfBirth();
 * -getAge();
 * -getTotalPerson();
 * ==Other Methods==
 * -greet();
 * -farewell();
 * -toString();
 *
 */

public class Person {
    private static int totalPerson;
    private int personID;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private byte age;

    static {
        totalPerson += 1;
    }

    public Person(){
    }

    public Person(String byVal_firstname, String byVal_lastname) {
        setNames(byVal_firstname, byVal_lastname);
    }

    public Person(String byVal_firstname, String byVal_lastname, String byVal_dateOfBirth, byte byVal_age){
        setNames(byVal_firstname, byVal_lastname);
        this.dateOfBirth = byVal_dateOfBirth;
        this.age = byVal_age;
    }

    public void setNames(String byVal_firstname, String byVal_lastname){
        DataUtilities utilities = new DataUtilities();
        if (byVal_firstname == null || byVal_firstname.isEmpty()) throw new IllegalArgumentException("First name cannot be null or empty");
        if (byVal_lastname == null || byVal_lastname.isEmpty()) throw new IllegalArgumentException("Surname cannot be null or empty");
        setFirstname(utilities.capitalise(byVal_firstname));
        setLastname(utilities.capitalise(byVal_lastname));
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Integer getPersonID() {
        return personID;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    public String getFullname () {
        return firstname + " " + lastname;
    }

    public String getFormattedName() {
        return lastname.toUpperCase() + ", " + firstname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Byte getAge() {
        return age;
    }
    public static Integer getTotalPerson() {
        return totalPerson;
    }

    public String greet() {
        return "Hello, " + getFirstname () + ".";
    }

    public String farewell(){
        return "Goodbye, " + getFirstname () + ".";
    }

    @Override
    public String toString() {
        return "Personal Information " +
                "\n==============================================================" +
                "\nFull Name: " + getFullname() +
                "\nDate Of Birth: " + dateOfBirth + '\'' +
                "\nAge: " + age +
                '}';
    }
}

