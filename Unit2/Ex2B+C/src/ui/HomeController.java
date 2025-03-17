package ui;

import java.util.Scanner;

public class HomeController {


    public static void displayWelcomeMessage() {
        System.out.println("+ ===================== +\n+ buisness.Apartment Manager App +\n+ ===================== +\n");

    }

    public static void printHomeScreen() {
        displayWelcomeMessage();

        displayHomeMenu();

        goodbyeMessage();
    }

    public static void displayHomeMenu() {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        while (!exit) {

            displayOptions();
            String userInput = sc.nextLine();
            if(userInput.equals("1") || userInput.equalsIgnoreCase("display tenants"))  {
                TenantsController.displayAllPersons();
            }

            else if(userInput.equals("2") || userInput.equalsIgnoreCase("display apartments")) {
                ApartmentsController.displayAllApartments();
            }
            else if(userInput.equals("3") || userInput.equalsIgnoreCase("exit")) {
                exit = true;
            }
        }
    }

    public static void displayOptions() {
        System.out.print("""
                        + TENANT MANAGEMENT +
                        ------------------------------
                        Please select one of the following options:
                            [1] Display Tenants
                            [2] Display Apartments
                            [3] Exit
    
                            Your Choice:""");

    }

    public static void goodbyeMessage() {
        System.out.println("Goodbye!");
    }

}
