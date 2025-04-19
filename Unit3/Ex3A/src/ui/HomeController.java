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
            if(userInput.equals("1")) {
                TenantsController.displayMenuAndHandleUserInput();
            }
            else if(userInput.equals("2"))  {
                ApartmentsController.displayAllApartments();
            }

            else if(userInput.equals("3")) {
                exit = true;
            }
        }
    }

    public static void displayOptions() {
        System.out.print("""
                        Select one of the following:
                        
                        Please select one of the following options:
                            [1] Manage Tenants
                            [2] Display Apartments
                            [3] Exit
   
                        Your Choice:""");

    }

    public static void goodbyeMessage() {
        System.out.println("Goodbye!");
    }

}
