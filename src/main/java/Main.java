package main.java;

import operations.AccountProcess;
import test.customer.TestAddCustomer;

import java.io.FileNotFoundException;

public class Main {
    static AccountProcess accountProcess;

    public static void main(String[] args) throws FileNotFoundException {
        accountProcess = new AccountProcess();

        TestAddCustomer testAddCustomer = new TestAddCustomer(accountProcess);

        testAddCustomer.readDataCsv();


        testAddCustomer.getCsvData().forEach(user -> System.out.println(user.toString()));
//        System.out.println(testAddCustomer.getCsvData().size());
    }
}
