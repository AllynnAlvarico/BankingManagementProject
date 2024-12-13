package main.java;

import operations.AccountProcess;

public class Main {
    static AccountProcess accountProcess;

    public static void main(String[] args){
        accountProcess = new AccountProcess();
        accountProcess.createUserAccount("allynn", "Alvarico", "allynn91", "08213edd");
        accountProcess.setCustomerAddress("4 Mill Road", "Killincarrig", "Greystones", "Co.Wicklow", "A63 C566");
        accountProcess.setAccountUserContact("083-803-6372", "allynn_alvarico@yahoo.com");
        accountProcess.setAccountOther("PL1234567890");
        accountProcess.setAccountType(1);


        System.out.println(accountProcess.getAccountUser().toString());
    }
}
