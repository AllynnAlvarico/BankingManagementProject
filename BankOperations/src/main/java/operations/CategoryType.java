package operations;

public enum CategoryType{

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
