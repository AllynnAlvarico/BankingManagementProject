package main.java;

import data.customer.Gender;
import operations.AccountProcess;
import test.customer.TestAddCustomer;

import java.io.FileNotFoundException;

public class Main {
    static AccountProcess accountProcess;

    public static void main(String[] args) throws FileNotFoundException {
        accountProcess = new AccountProcess();

        accountProcess.createUserAccount("John", "Doe", "1990-01-01", "American",
                "123 Main St", "Apt 4B", "Springfield", "IL", "62704",
                Gender.MALE, (byte) 34, "john.doe@example.com", "+1-555-123-4567");

        System.out.println(accountProcess.getAccountUser().toString());


//        TestAddCustomer testAddCustomer = new TestAddCustomer(accountProcess);
//
//        testAddCustomer.readDataCsv();
//
//
//        testAddCustomer.getCsvData().forEach(user -> System.out.println(user.toString()));
//        System.out.println(testAddCustomer.getCsvData().size());
    }
}
