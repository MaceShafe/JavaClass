package ui;

import buisness.Tenant;
import data.TenantDB;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TenantsController {
    private static final Scanner sc = new Scanner(System.in);

    public static void displayMenuAndHandleUserInput() {
        int userChoice = 0;
        do{
            userChoice = 0;

            displayTenantsMenu();
            userChoice = handleUserInput();

        } while (userChoice != 5);
    }

    public static void displayTenantsMenu() {
        System.out.print("""
                        + TENANT MANAGEMENT +
                        ------------------------------
                        Please select one of the following options:
                            [1] Register New Tenant
                            [2] Display All tenants
                            [3] Display Single Tenant
                            [4] Remove Tenant
                            [5] Exit.
   
                            Your Choice:""");


    }




    public static int handleUserInput() {

        int choice = 0;

        try {
            choice = sc.nextInt();

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid input \n");

        } catch (Exception e) {
            System.out.println("Something went wrong, try again. \n");
        }

        switch (choice) {
            case 1 -> registerTenant();
            case 2 -> displayAllTenants();
            case 3 -> findSingleTenant(false);
            case 4 -> findSingleTenant(true);

        }
        return choice;


    }



    private static void displayTenantAsTableRow(Tenant tenant) {
        System.out.printf("| %-3d | %-14s | %-12s | %-12s | $%,-14.2f |\n",
                tenant.getPersonId(),
                tenant.getUserName(),
                tenant.getFirstName(),
                tenant.getLastName(),
                tenant.getCurrentBalance());
    }

    public static void findSingleTenant(Tenant tenant) {
        System.out.printf("""
                    Tenant %s %s
                    ------------------------------
                    Id: %d
                    First Name:%s
                    Last Name:%s
                    User Name:%s
                    Current Wage: $%,.2f
                    Date added to DB: %tD
                    """,
                tenant.getFirstName(),
                tenant.getLastName(),

                tenant.getPersonId(),
                tenant.getFirstName(),
                tenant.getLastName(),
                tenant.getUserName(),
                tenant.getCurrentBalance(),
                tenant.getCreationDate());
    }


    public static void findSingleTenant(boolean delete) {
        System.out.print("Please enter the Tenant ID: ");


            try {
                int tenantId = sc.nextInt();
                Tenant tenant = TenantDB.getTenantByID(tenantId);

                if (tenant == null) {
                    System.out.println("That tenant was not found! ");
                } else {
                    if (delete) {
                        confirmTenantDeletion(tenant); }
                    else {
                        findSingleTenant(tenant);
                    }
                }
            } catch (InputMismatchException InputMismatchException) {
                System.out.println("ID is not valid! Try Again");
            }
//Known bug: typing any non-integer characters will result in program continuously looping through menu fix later.

    }

    private static void confirmTenantDeletion(Tenant tenant) {
        System.out.printf("Are you sure you want to delete (%d) '%s %s'? (y/n)", tenant.getPersonId(), tenant.getFirstName(), tenant.getLastName()) ;

        String choice = sc.next();


        if (choice.equalsIgnoreCase("y")) {
            TenantDB.removeTenant(tenant);
            System.out.println("Tenant successfully removed, goodbye!");
        } else if (sc.next().equalsIgnoreCase("n")) {
            System.out.println("Tenant not removed!");
        }


    }

    public static void displayAllTenants() {

        String TABLE_LINE = "-----------------------------------------------------------------------";


    if (!TenantDB.getAllTenants().isEmpty()) {
        System.out.println(TABLE_LINE);
        System.out.printf("| %-3s | %-14s | %-12s | %-12s | %-14s |\n", "Id", "User Name", "First Name", "Last Name", "Current Balance" );
        System.out.println(TABLE_LINE);


        for (Tenant tenant : TenantDB.getAllTenants()) {

                displayTenantAsTableRow(tenant);
                System.out.println(TABLE_LINE);

            }
    } else {
        System.out.println("No tenants found");
    }

        System.out.println();

//        for (int i = 1; i<= TenantDB.getNextId(); i++ ) {
//
//            Tenant person = TenantDB.getTenantByID(i);
//
//            if (person != null){
//                displaySingleTenant(person);
//            }
//        }
    }

    public static void registerTenant() {

        Tenant newTenant = new Tenant();
        boolean isValid = false;
        String userInput = null;
        String fName = null, lName = null;
        try{
        while (!isValid) {
            System.out.println("User First Name:");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 12);
            if (!isValid) {
                System.out.println("Text must be under 12 characters and not empty.");
            }
        }
        isValid = false;
        newTenant.setFirstName(userInput);

        while (!isValid) {
            System.out.println("User Last Name:");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 12);
            if (!isValid) {
                System.out.println("Text must be under 12 characters and not empty.");
            }
        }
        isValid = false;
        newTenant.setLastName(userInput);
        while (!isValid) {
            System.out.println("Username (if blank, will default to " + newTenant.getFirstName() + "." + newTenant.getLastName() + "." +newTenant.getPersonId() + "):");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 50);
            if (!isValid) {
                userInput =  newTenant.getFirstName() + "." + newTenant.getLastName () + "." +newTenant.getPersonId();
                isValid = true;
            }
        }
        isValid = false;
        newTenant.setUserName(userInput);
            while (!isValid) {
                System.out.println("Current Tenant Wage: ");
                userInput = sc.nextLine();
                try {
                    double wage = Double.parseDouble(userInput);
                    isValid = true;
                    newTenant.setCurrentBalance(wage);
                }
                catch (NumberFormatException e) {
                    System.out.println("Please insert an amount.");
                }
            }
            newTenant.setCreationDate();

            System.out.println("New Tenant:");
        TenantDB.addTenant(newTenant);
        findSingleTenant(newTenant);}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



public static boolean isCharacterLimitReached(String text, int length)  {
        if (text.length()>length || text.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
}
