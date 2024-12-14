package operations;

import data.CustomerInformation;

enum AccountType{

    CHECKING ("Checking Account"),
    SAVING ("Savings Account"),
    BUSINESS ("Business Account");
    private String typeAccount;
    private String getTypeAccount(){return typeAccount;}

    AccountType(String s) {
        typeAccount = s;
    }

    @Override
    public String toString() {
        return getTypeAccount();
    }
}
enum CategoryType{

    YOUTH ("Youth", 0.02, 0, 0),
    STUDENT ("Student", 0.025, 0, 0),
    PERSONAL ("Regular", 0.015, 0.005, 10),
    SENIOR_CITIZEN ("Senior Citizen", 0.03, 0.05, 0),
    BUSINESS ("Business", 0.01, 0.005, 100),
    PREMIUM ("Premium/VIP", 0.025, 0.01, 50),
    BLACKLISTED ("High-Risk/Blacklisted", 0.25, 0, 15);
    private String category;
    private double savings;
    private double checking;
    private double fees;
    private String getTypeCategory(){return category;}

    CategoryType(String byVal_category, double byVal_savings, double byVal_checking, double byVal_fees) {
        this.category = byVal_category;
        this.savings = byVal_savings;
        this.checking = byVal_checking;
        this.fees = byVal_fees;
    }

    public String getDescription(String byVal_category){
        String description = "";

        switch (byVal_category){
            case "Youth" -> description = "Accounts for teenagers or minors, often managed jointly with a parent or guardian.";
            case "Student" -> description = "Accounts for students with low or no fees, limited services, and benefits like no overdraft charges.";
            case "Senior Citizen" -> description = "Accounts for individuals over a certain age (e.g., 60+), offering higher interest rates, reduced fees, and dedicated benefits.";
            case "Business" -> description = "Accounts for small businesses or corporations, offering features like payroll processing and higher transaction limits.";
            case "Premium/VIP" -> description = "High-income or high-net-worth individuals with exclusive benefits like dedicated relationship managers, higher withdrawal limits, and investment advice.";
            case "High-Risk/Blacklisted" -> description = "Customers flagged due to suspicious activities, regulatory watchlists, or poor credit history.";
            default -> description = "General-purpose accounts for individuals with standard services and fees.";
        }
        return description;
    }

    @Override
    public String toString() {
        return getTypeCategory();
    }
}
public class AccountProcess {
    private CustomerInformation accountUser;
    // Test Description for the Category
    private String descriptionCategory;

    public void createUserAccount(String byVal_name, String byVal_surname, String byVal_username, String byVal_password) {
        accountUser = new CustomerInformation(byVal_name, byVal_surname, byVal_username, byVal_password);
        accountUser.setAccountNumber();
        accountUser.setCardNumber();
        accountUser.setCardPin();
        accountUser.setBalance();
    }
//    public void createUserAccount(
//            String byVal_name, String byVal_surname, String byVal_username, String byVal_password,
//            String byVal_accountNumber, String byVal_cardNumber, String byVal_cardPin, String byVal_balance
//    ) {
//        accountUser = new CustomerInformation(byVal_name, byVal_surname, byVal_username, byVal_password);
//        accountUser.setAccountNumber(byVal_accountNumber);
//        accountUser.setCardNumber(byVal_cardNumber);
//        accountUser.setCardPin(byVal_cardPin);
//        accountUser.setBalance(byVal_balance);
//    }

    public void setCustomerAddress(String byVal_address1, String byVal_address2, String byVal_town, String byVal_state, String byVal_zipcode) {
        accountUser.setAddress1(byVal_address1);
        accountUser.setAddress2(byVal_address2);
        accountUser.setTown(byVal_town);
        accountUser.setState(byVal_state);
        accountUser.setZipcode(byVal_zipcode);
    }

    public void setAccountUserContact(String byVal_phoneNumber, String byVal_email) {
        accountUser.setPhoneNumber(byVal_phoneNumber);
        accountUser.setEmail(byVal_email);
    }

    public void setAccountOther(String byVal_passport) {
        accountUser.setPassportInformation(byVal_passport);
        accountUser.setAccountUniqueId();
    }

    public void setAccountType(int byVal_selectedAccountType) {
        switch (byVal_selectedAccountType) {
            case 1 -> accountUser.setAccountType(AccountType.BUSINESS.toString());
            case 2 -> accountUser.setAccountType(AccountType.SAVING.toString());
            default -> accountUser.setAccountType(AccountType.CHECKING.toString());
        }
    }
    public void setCategoryType(int byVal_selectedType){
        switch (byVal_selectedType) {
            case 1:
                accountUser.setCategory(CategoryType.YOUTH.toString());
                descriptionCategory = CategoryType.YOUTH.getDescription(CategoryType.YOUTH.toString());
//                System.out.println(CategoryType.YOUTH.getDescription(CategoryType.YOUTH.toString()));
                break;
            case 2 :
                accountUser.setCategory(CategoryType.STUDENT.toString());
                descriptionCategory = CategoryType.STUDENT.getDescription(CategoryType.STUDENT.toString());
//                System.out.println(CategoryType.STUDENT.getDescription(CategoryType.STUDENT.toString()));
                break;
            case 3:
                accountUser.setCategory(CategoryType.SENIOR_CITIZEN.toString());
                descriptionCategory = CategoryType.SENIOR_CITIZEN.getDescription(CategoryType.SENIOR_CITIZEN.toString());
//                System.out.println(CategoryType.SENIOR_CITIZEN.getDescription(CategoryType.SENIOR_CITIZEN.toString()));
                break;
            case 4:
                accountUser.setCategory(CategoryType.BUSINESS.toString());
                descriptionCategory = CategoryType.BUSINESS.getDescription(CategoryType.BUSINESS.toString());
//                System.out.println(CategoryType.BUSINESS.getDescription(CategoryType.BUSINESS.toString()));
                break;
            case 5:
                accountUser.setCategory(CategoryType.PREMIUM.toString());
                descriptionCategory = CategoryType.PREMIUM.getDescription(CategoryType.PREMIUM.toString());
//                System.out.println(CategoryType.PREMIUM.getDescription(CategoryType.PREMIUM.toString()));
                break;
            case 6:
                accountUser.setCategory(CategoryType.BLACKLISTED.toString());
                descriptionCategory = CategoryType.BLACKLISTED.getDescription(CategoryType.BLACKLISTED.toString());
//                System.out.println(CategoryType.BLACKLISTED.getDescription(CategoryType.BLACKLISTED.toString()));
                break;
            default:
                accountUser.setCategory(CategoryType.PERSONAL.toString());
                descriptionCategory = CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.toString());
//                System.out.println(CategoryType.PERSONAL.getDescription(CategoryType.PERSONAL.toString()));
                break;
        }
    }

    //Test getter Method for Category Descriptions
    public String getDescriptionCategory(){
        return descriptionCategory;
    }

    public CustomerInformation getAccountUser() {
        return accountUser;
    }
}
