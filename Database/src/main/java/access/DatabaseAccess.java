package access;

import com.healthmarketscience.jackcess.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
//
//
public class DatabaseAccess {
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
    private final File dbFile;

    public DatabaseAccess() {
        // Define the database file path
        this.dbFile = new File("resource/UserDatabase.accdb");
        createDatabaseFile();
    }

    private void createDatabaseFile() {
        try {
            if (!dbFile.exists()) {
                // Create a new database
                Database database = DatabaseBuilder.create(Database.FileFormat.V2010, dbFile);

                // Create tables
                createCustomerTable(database);
                createAccountTable(database);

                // Insert sample data
                insertSampleData(database);

                database.close();
                System.out.println("Database created successfully at: " + dbFile.getAbsolutePath());
            } else {
                System.out.println("Database already exists at: " + dbFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    private void createCustomerTable(Database database) throws IOException {
        new TableBuilder("Customer")
                .addColumn(new ColumnBuilder("ID")
                        .setType(DataType.LONG)
                        .setAutoNumber(true)) // Auto-increment primary key
                .addColumn(new ColumnBuilder("Name").setType(DataType.TEXT))
                .addColumn(new ColumnBuilder("Surname").setType(DataType.TEXT))
                .addColumn(new ColumnBuilder("Username").setType(DataType.TEXT))
                .addColumn(new ColumnBuilder("Email Address").setType(DataType.TEXT))
                .addColumn(new ColumnBuilder("Phone Number").setType(DataType.TEXT))
                .toTable(database);
    }

    private void createAccountTable(Database database) throws IOException {
        new TableBuilder("Account")
                .addColumn(new ColumnBuilder("Account ID").setType(DataType.LONG))
                .addColumn(new ColumnBuilder("Account Number").setType(DataType.TEXT))
                .addColumn(new ColumnBuilder("Account Balance").setType(DataType.MONEY))
                .addColumn(new ColumnBuilder("Account Type").setType(DataType.TEXT))
                .toTable(database);
    }

    private void insertSampleData(Database database) throws IOException {
        // Example data for Customer table
        List<Map<String, Object>> customers = List.of(
                Map.of("Name", "John", "Surname", "Doe", "Username", "jdoe", "Email Address", "jdoe@example.com", "Phone Number", "1234567890"),
                Map.of("Name", "Jane", "Surname", "Smith", "Username", "jsmith", "Email Address", "jsmith@example.com", "Phone Number", "0987654321")
        );

        Table customerTable = database.getTable("Customer");
        for (Map<String, Object> row : customers) {
            customerTable.addRowFromMap(row);
        }

        // Example data for Account table
        List<Map<String, Object>> accounts = List.of(
                Map.of("Account ID", 1, "IBAN Number", "IE29AIBK93115212345678", "Account Balance", 5000.00, "Account Type", "Savings"),
                Map.of("Account ID", 2, "IBAN Number", "IE29AIBK93115298765432", "Account Balance", 1500.00, "Account Type", "Checking")
        );

        Table accountTable = database.getTable("Account");
        for (Map<String, Object> row : accounts) {
            accountTable.addRowFromMap(row);
        }

        System.out.println("Sample data inserted successfully.");
    }

    public void addRow(String tableName, Map<String, Object> rowData) {
        try {
            Database db = DatabaseBuilder.open(dbFile);
            Table table = db.getTable(tableName);
            table.addRowFromMap(rowData);
            db.close();
            System.out.println("Row added to table: " + tableName);
        } catch (IOException e) {
            System.err.println("Error adding row to table: " + e.getMessage());
        }
    }

    // Method to generate rows of data
    public List<Map<String, Object>> generateRows() {
        String[][][] dataSets = dataLists();
        List<Map<String, Object>> rows = new ArrayList<>();

        for (String[][] rowData : dataSets) {
            Map<String, Object> row = new HashMap<>(); // Use HashMap to ensure mutability
            for (String[] column : rowData) {
                if (column.length == 2) {
                    String key = column[0];
                    Object value = column[1];
                    row.put(key, value);
                } else {
                    System.err.println("Invalid column entry: " + Arrays.toString(column));
                }
            }
            rows.add(row); // Add the row to the list
        }

        return rows;
    }

    // Extended datasets
    public String[][][] dataLists() {
        return new String[][][] {
                {{"Account ID", "1"}, {"Name", "John Doe"}, {"Surname", "Doe"}, {"Username", "jdoe"}, {"Password", "password123"},
                        {"Address 1", "123 Elm Street"}, {"Address 2", "Apt 4B"}, {"Town/City", "Springfield"}, {"State", "IL"}, {"Zipcode", "62701"},
                        {"Phone Number", "123-456-7890"}, {"Email Address", "jdoe@example.com"}, {"Passport Number", "AB1234567"}, {"IBAN Number", "US1234567890"},
                        {"Card Number", "4111111111111111"}, {"Card Pin", "1234"}, {"Account Balance", "10000.50"}, {"Account Type", "Savings"}, {"Category Type", "Premium"}},

                {{"Account ID", "2"}, {"Name", "Jane Smith"}, {"Surname", "Smith"}, {"Username", "jsmith"}, {"Password", "pass987"},
                        {"Address 1", "456 Oak Avenue"}, {"Address 2", "Suite 12"}, {"Town/City", "Metropolis"}, {"State", "NY"}, {"Zipcode", "10001"},
                        {"Phone Number", "987-654-3210"}, {"Email Address", "jsmith@example.com"}, {"Passport Number", "CD7654321"}, {"IBAN Number", "US0987654321"},
                        {"Card Number", "4222222222222222"}, {"Card Pin", "5678"}, {"Account Balance", "5000.75"}, {"Account Type", "Checking"}, {"Category Type", "Basic"}}
        };
    }



    public void displayTableData(String tableName) {
        try {
            Database db = DatabaseBuilder.open(dbFile);
            Table table = db.getTable(tableName);

            System.out.println("Data in table " + tableName + ":");
            for (Row row : table) {
                System.out.println(row);
            }

            db.close();
        } catch (IOException e) {
            System.err.println("Error reading table data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseAccess dbAccess = new DatabaseAccess();
        dbAccess.displayTableData("Customer");
        dbAccess.displayTableData("Account");
    }
}

//
//    public DatabaseAccess() {
//        // Define the file where the database will be created
//        File dbFile = new File("resource\\UserDatabase.accdb");
//        createDatabaseFile(dbFile);
//
//    }
//    public void createDatabaseFile(File dbFile){
//        // Table name
//        String[] tableName = {"Customer", "Account", "Address", "Bank_Card", "Checking", "Savings", "Business", "Loan"};
//        try {
//            // Create a new database
//            Database database = DatabaseBuilder.create(Database.FileFormat.V2010, dbFile);
//
//            // Create the table
//            createCustomerTable(database, "Customer");
//
//
//
//            // Generate rows of data
//            List<Map<String, Object>> rows = generateRows();
//
//            // Add data to the table
//            for (Map<String, Object> rowData : rows) {
//                addingDataToTable(dbFile.getAbsolutePath(), tableName[0], rowData);
//            }
//
//            System.out.println("Database created successfully at: " + dbFile.getAbsolutePath());
//        } catch (IOException e) {
//            System.err.println("Error creating database: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//    }
//
//    // Method to create the table
//    public void createCustomerTable(Database byRef_db, String byVal_tableName) throws IOException {
//        new TableBuilder(byVal_tableName)
//                .addColumn(new ColumnBuilder("ID")
//                        .setType(DataType.LONG)
//                        .setAutoNumber(true)) // Auto-increment primary key
//                .addColumn(new ColumnBuilder("Name")
//                        .setType(DataType.TEXT))
//                .addColumn(new ColumnBuilder("Department")
//                        .setType(DataType.TEXT))
//                .addColumn(new ColumnBuilder("Salary")
//                        .setType(DataType.MONEY))
//                .toTable(byRef_db);
//    }
//
//    // Method to add data to the table
//    public void addingDataToTable(String dbFilePath, String tableName, Map<String, Object> rowData) {
//        try {
//            // Open the database
//            Database db = DatabaseBuilder.open(new File(dbFilePath));
//
//            // Get the table
//            Table table = db.getTable(tableName);
//
//            // Add a row to the table
//            table.addRowFromMap(rowData);
//
//            System.out.println("Added row: " + rowData);
//
//            // Close the database
//            db.close();
//        } catch (IOException e) {
//            System.err.println("Error adding data: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    // Method to generate rows of data
////    public List<Map<String, Object>> generateRows() {
////        String[][][] dataSets = dataLists();
////        List<Map<String, Object>> rows = new ArrayList<>();
////
////        for (String[][] rowData : dataSets) {
////            Map<String, Object> row = new HashMap<>();
////            for (String[] column : rowData) {
////                if (column.length == 2) {
////                    String key = column[0];
////                    Object value = column[1];
////                    row.put(key, value);
////                } else {
////                    System.err.println("Invalid column entry: " + Arrays.toString(column));
////                }
////            }
////            rows.add(row); // Add the row to the list
////        }
////
////        return rows;
////    }
//
//    // Method to generate rows of data
//    public List<Map<String, Object>> generateRows() {
//        String[][][] dataSets = dataLists();
//        List<Map<String, Object>> rows = new ArrayList<>();
//
//        for (String[][] rowData : dataSets) {
//            Map<String, Object> row = new HashMap<>(); // Use HashMap to ensure mutability
//            for (String[] column : rowData) {
//                if (column.length == 2) {
//                    String key = column[0];
//                    Object value = column[1];
//                    row.put(key, value);
//                } else {
//                    System.err.println("Invalid column entry: " + Arrays.toString(column));
//                }
//            }
//            rows.add(row); // Add the row to the list
//        }
//
//        return rows;
//    }
//
//
//    //     Method to define datasets
//    public String[][][] dataLists() {
//        return new String[][][]{
//                {{"Name", "John Doe"}, {"Department", "IT"}, {"Salary", "60000.00"}},
//                {{"Name", "Jane Smith"}, {"Department", "HR"}, {"Salary", "55000.00"}},
//                {{"Name", "Alice Johnson"}, {"Department", "Finance"}, {"Salary", "70000.00"}},
//                {{"Name", "Bob Brown"}, {"Department", "IT"}, {"Salary", "62000.00"}},
//                {{"Name", "Charlie White"}, {"Department", "Marketing"}, {"Salary", "48000.00"}},
//                {{"Name", "David Green"}, {"Department", "IT"}, {"Salary", "61000.00"}},
//                {{"Name", "Eve Black"}, {"Department", "Sales"}, {"Salary", "50000.00"}},
//                {{"Name", "Frank Blue"}, {"Department", "HR"}, {"Salary", "56000.00"}},
//                {{"Name", "Grace Pink"}, {"Department", "Finance"}, {"Salary", "72000.00"}},
//                {{"Name", "Hank Yellow"}, {"Department", "Marketing"}, {"Salary", "47000.00"}}
//        };
//    }
//
//
//}
