package test.customer;

import data.CustomerInformation;
import operations.AccountProcess;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestAddCustomer {

    private final String myFile = "resource\\UserDatabase.csv";
    private final String[] headers = {
            "Customer Account ID", "Name", "Surname", "Username", "Password",
            "Address 1", "Address 2", "Town/City", "State", "Zipcode",
            "Phone Number", "Email Address", "Passport Number", "Account Type", "Category Type"
    };

    private ArrayList<CustomerInformation> csvData = new ArrayList<>();
    private AccountProcess accTest;

    public TestAddCustomer() {

        createCsvFile();

    }

    public TestAddCustomer(AccountProcess accTest) {
        this.accTest = accTest;

        accTest.createUserAccount("allynn", "Alvarico", "allynn91", "08213edd");
        accTest.setCustomerAddress("4 Mill Road", "Killincarrig", "Greystones", "Co.Wicklow", "A63 C566");
        accTest.setAccountUserContact("083-803-6372", "allynn_alvarico@yahoo.com");
        accTest.setAccountOther("PL1234567890");
        accTest.setAccountType(1);
        accTest.setCategoryType(1);
    }


    public void createCsvFile() {
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(this.myFile))) {
            csvWriter.println(String.join(",", this.headers));
//            data.initialiseParameters(csvWriter);
            System.out.println("CSV file with headers created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataCsv() {

        String line;
        String splitBy = ",";

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(this.myFile));
            System.out.println("\f");
//            System.out.println(tableLines);
            while ((line = csvReader.readLine()) != null)// &&
            {
                CustomerInformation customer = new CustomerInformation();
                String[] item = line.split(splitBy);
                if (!line.contains("Customer Account ID")) {
                    customer.setCustomerID(String.valueOf(item[0]));
                    customer.setName(item[1]);
                    customer.setSurname(item[2]);
                    customer.setUsername(item[3]);
                    customer.setPassword(item[4]);
                    customer.setAddress1(item[5]);
                    customer.setAddress2(item[6]);
                    customer.setTown(item[7]);
                    customer.setState(item[8]);
                    customer.setZipcode(item[9]);
                    customer.setPhoneNumber(item[10]);
                    customer.setEmail(item[11]);
                    customer.setPassportInformation(item[12]);
                    customer.setAccountType(item[13]);
                    customer.setCategory(item[14]);

                    csvData.add(customer);
                }
//                data.printData(item, tableLines);
            }
//            data.generateReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CustomerInformation> getCsvData() {
        return csvData;
    }
}
//
//
//
//
//
//    public String[] testNames(){
//        String[] testListName = {
//                "Michael Jackson",//1
//                "Johnny Depp",//2
//                "Rowan Atkinson",//3
//                "Jackie Chan",//4
//                "Adam Sandler",//5
//                "Megan Fox",//6
//                "Bill Gates",//7
//                "Jeff Bezos",//8
//                "Richard Branson",//9
//                "Elon Musk",//10
//        };
//
//        return testListName;
//    }
//    // [][][] This is a 3D Array
//    // [User Object or Entities][Object Element 1][Object Element 2]
//    public String[][][] testUserAccounts(){
//        String[][][] testListUsers = {
//                //{Object Reference{1st Element}{2nd Element}}
//                {{"ClumsiestSlow"}, {"SC4:As8uxD6@[qkK+2&E;`"}},
//                {{"PixiePaddle"}, {"CZ!$W8Y_u4mz~F9=QXp*s)"}},
//                {{"TruthfulSunflower"}, {"H8?Dy9Y.kQ;Nd:gT,`+Zcw"}},
//                {{"ReaderReturner"}, {"SUw\"be+E&`V,ur'5{L@BQ;"}},
//                {{"PetiteSniper"}, {"bMPZ8:_F9=zRD{7T5Gkp,x"}},
//                {{"SurgingCrowd"}, {"s{83)#?5kD!9h=*6EYj$/R"}},
//                {{"PatternChampion"}, {"Y]B%ahdXP)`?A$v,.HwR7s"}},
//                {{"ImproveLanguage"}, {"w\"Bue^@7rnt2L{cxCbD:M["}},
//                {{"DreamscapesEcho"}, {"j,KTs;FVfzA-c+?H^B/4(m"}},
//                {{"VoiceBubble"}, {"nZp2A[%b?-35+tXLTP_}9z"}},
//        };
//        return testListUsers;
//    }
//    //[Object Array][Object][Object Elements]
//    public String[][][] testPersonalAddress(){
//        String[][][] testAdddressList = {//1st Array
//                //{2nd Array{3rd Array}, {3rd Array}, {3rd Array}}
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//                {{"5023 "}, {"Stroman Circles"}, {"Lake Ellieland"}, {"Ellieland"}, {"MT 13204-4103"}},
//                {{"5405 "}, {"Grant Rapid"}, {"Cummingsville"}, {"Cummingsville"}, {"MN 76284"}},
//                {{"Apt. 851 934"}, {"Gaston Forest"}, {"North Brindashire"}, {"Brindashire"}, {"OH 09550"}},
//                {{"4145 "}, {"Davis Plaza"}, {"Lake Wenona"}, {"Wenona"}, {"AL 20044-7809"}},
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//                {{"141"}, {"Pfannerstill Trail"}, {"East Dorene"}, {"Dorene"}, {"DE 38395-3998"}},
//        };
//        return testAdddressList;
//    }

