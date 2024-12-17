package test.customer;

import data.Customer;
import operations.AccountProcess;
import util.DataUtilities;

import java.io.*;
import java.util.ArrayList;

public class TestAddCustomer {

    DataUtilities utilities;


    private final String myFile = "resource\\UserDatabase.csv";
//    PrintWriter csvWriter = new PrintWriter();
    private final String[] headers = {
            // 0            1         2           3          4
            "Account ID", "Name", "Surname", "Username", "Password",
            // 5            6               7         8         9
            "Address 1", "Address 2", "Town/City", "State", "Zipcode",
            //  10              11              12                  13
            "Phone Number", "Email Address", "Passport Number", "IBAN Number",
            // 14               15          16              17              18
            "Card Number", "Card Pin", "Account Balance","Account Type", "Category Type"
    };

    private ArrayList<Customer> csvData;
    private AccountProcess accTest;
    {
        utilities = new DataUtilities();
        csvData = new ArrayList<>();
    }

    public TestAddCustomer() {
        File userDataFile = new File(myFile);
        if (!userDataFile.exists()){
            createCsvFile();
        }
    }

    public TestAddCustomer(AccountProcess accTest) {
//        this.accTest = accTest;

        File userDataFile = new File(myFile);
        if (!userDataFile.exists()){
            createCsvFile();
        }
//        accTest.createUserAccount("Kate", "Samson", "casselyn.kate", "08213edd");
//        accTest.setCustomerAddress("4 Mill Road", "Killincarrig", "Greystones", "Co.Wicklow", "A63 C566");
//        accTest.setAccountUserContact("086-404-2923", "allynn_alvarico@yahoo.com");
//        accTest.setAccountOther("PL1234567890");
//        accTest.setAccountType(1);
//        accTest.setCategoryType(1);

        addDataElement(accTest);


    }


    public void createCsvFile() {

        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(this.myFile))) {
            csvWriter.println(String.join(",", this.headers));
            System.out.println("CSV file with headers created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void readDataCsv() {
//
//        String line;
//        String splitBy = ",";
//
//        try {
////            BufferedReader csvReader = new BufferedReader(new FileReader(this.myFile));
////            while ((line = csvReader.readLine()) != null)// &&
////            {
//////                CustomerInformation customer = new CustomerInformation();
//////                String[] item = line.split(splitBy);
//////                if (!line.contains(headers[0])) {
//////                    customer.setCustomerID(item[0]);
//////                    customer.setName(item[1]);
//////                    customer.setSurname(item[2]);
//////                    customer.setUsername(item[3]);
//////                    customer.setPassword(item[4]);
//////                    customer.setAddress1(item[5]);
//////                    customer.setAddress2(item[6]);
//////                    customer.setTown(item[7]);
//////                    customer.setState(item[8]);
//////                    customer.setZipcode(item[9]);
//////                    customer.setPhoneNumber(item[10]);
//////                    customer.setEmail(item[11]);
//////                    customer.setPassportInformation(item[12]);
//////                    customer.setAccountNumber(item[13]);
//////                    customer.setCardNumber(item[14]);
//////                    customer.setCardPin(item[15]);
//////                    customer.setBalance(item[16]);
//////                    customer.setAccountType(item[17]);
//////                    customer.setCategory(item[18]);
////
////                    csvData.add(customer);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public void addDataElement(AccountProcess accountProcess) {

        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(this.myFile, true))){

            Customer customer = accountProcess.getAccountUser();
//            String[] data = getCustomerData(customer);
//            csvWriter.println(String.join(",", data));

        }catch (IOException e) {e.printStackTrace();}

    }

//    private String[] getCustomerData(CustomerInformation customer) {
//        return new String[] {
//                String.valueOf(customer.getCustomerId()),
//                utilities.capitalise(customer.getName()),
//                utilities.capitalise(customer.getSurname()),
//                customer.getUsername(),
//                customer.getPassword(),
//                utilities.capitalise(customer.getAddressOne()),
//                utilities.capitalise(customer.getAddressTwo()),
//                utilities.capitalise(customer.getTown()),
//                utilities.capitalise(customer.getState()),
//                customer.getZipcode(),
//                customer.getPhoneNumber(),
//                customer.getEmail(),
//                customer.getPassportNumber(),
//                customer.getAccountNumber(),
//                customer.getCardInformation().cardNumber(),
//                String.valueOf(customer.getPinCard()),
//                String.valueOf(customer.getBalance()),
//                customer.getAccountType(),
//                customer.getCategory()
//        };
//    }


    public ArrayList<Customer> getCsvData() {
        return csvData;
    }
}
/*
    public String[] testNames(){
        String[] testListName = {
                "Michael Jackson",//1
                "Johnny Depp",//2
                "Rowan Atkinson",//3
                "Jackie Chan",//4
                "Adam Sandler",//5
                "Megan Fox",//6
                "Bill Gates",//7
                "Jeff Bezos",//8
                "Richard Branson",//9
                "Elon Musk",//10
        };

        return testListName;
    }
    // [][][] This is a 3D Array
    // [User Object or Entities][Object Element 1][Object Element 2]
    public String[][][] testUserAccounts(){
        String[][][] testListUsers = {
                //{Object Reference{1st Element}{2nd Element}}
                {{"ClumsiestSlow"}, {"SC4:As8uxD6@[qkK+2&E;`"}},
                {{"PixiePaddle"}, {"CZ!$W8Y_u4mz~F9=QXp*s)"}},
                {{"TruthfulSunflower"}, {"H8?Dy9Y.kQ;Nd:gT,`+Zcw"}},
                {{"ReaderReturner"}, {"SUw\"be+E&`V,ur'5{L@BQ;"}},
                {{"PetiteSniper"}, {"bMPZ8:_F9=zRD{7T5Gkp,x"}},
                {{"SurgingCrowd"}, {"s{83)#?5kD!9h=*6EYj$/R"}},
                {{"PatternChampion"}, {"Y]B%ahdXP)`?A$v,.HwR7s"}},
                {{"ImproveLanguage"}, {"w\"Bue^@7rnt2L{cxCbD:M["}},
                {{"DreamscapesEcho"}, {"j,KTs;FVfzA-c+?H^B/4(m"}},
                {{"VoiceBubble"}, {"nZp2A[%b?-35+tXLTP_}9z"}},
        };
        return testListUsers;
    }
    //[Object Array][Object][Object Elements]
    public String[][][] testPersonalAddress(){
        String[][][] testAdddressList = {//1st Array
                //{2nd Array{3rd Array}, {3rd Array}, {3rd Array}}
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
                {{"5023 "}, {"Stroman Circles"}, {"Lake Ellieland"}, {"Ellieland"}, {"MT 13204-4103"}},
                {{"5405 "}, {"Grant Rapid"}, {"Cummingsville"}, {"Cummingsville"}, {"MN 76284"}},
                {{"Apt. 851 934"}, {"Gaston Forest"}, {"North Brindashire"}, {"Brindashire"}, {"OH 09550"}},
                {{"4145 "}, {"Davis Plaza"}, {"Lake Wenona"}, {"Wenona"}, {"AL 20044-7809"}},
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
        };
        return testAdddressList;
    }
*/

