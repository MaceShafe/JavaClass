package ui;

import data.ApartmentDB;
import data.PersonDB;
import buisness.Person;
import buisness.Apartment;

import java.text.NumberFormat;
import java.util.Scanner;

public class PropertyManager {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            boolean exit = false;

            //Welcome Message
            displayWelcomeMessage();

            while(!exit) {
                displayOptions();
                String userInput = sc.nextLine();
                if(userInput.equals("1") || userInput.equalsIgnoreCase("register new tenant"))  {
                    registerPerson();
                }
                else if(userInput.equals("2") || userInput.equalsIgnoreCase("display all tenants")) {
                    displayAllPersons();                }
                else if(userInput.equals("3") || userInput.equalsIgnoreCase("display single tenant")) {
                    exit = true;
                }
                else if(userInput.equals("4") || userInput.equalsIgnoreCase("exit")) {
                    exit = true;
                }
            }



//            //Core funtionality
//            Person person1 = PersonDB.getPerson(1);
//            displayPerson(person1);
//            Person person2 = new Person(person1);
//            displayPerson(person2);
//
//            Person person3 = new Person();
//            displayPerson(person3);
//
//            Apartment apartment1 = ApartmentDB.getApartment(1);
//            apartment1.setTenant(person1);
//
//            displayApartment(apartment1);
//            Apartment apartment2 = ApartmentDB.getApartment(2);
//            apartment2.setTenant(person2);
//
//
//            displayApartment(apartment2);
//            displayTotals(apartment1, apartment2);
        }



        private static void displayWelcomeMessage() {
            System.out.println("+ ===================== +\n+ buisness.Apartment Manager App +\n+ ===================== +\n");

        }

        private static void displayOptions() {
            System.out.printf("""
                    + TENANT MANAGEMENT +
                    ------------------------------
                    Please select one of the following options:
                        [1] Register new Tenant
                        [2] Display all Tenants
                        [3] Display single Tenant
                        [4] Exit
                        
                        """);

        }

    private static void registerPerson() {

        Person newPerson = new Person();
        Scanner sc = new Scanner(System.in);;

        System.out.println("User First Name:");
        String userInput = sc.nextLine();

        newPerson.setFirstName(userInput);
        System.out.println("User Last Name:");
        userInput = sc.nextLine();
        newPerson.setLastName(userInput);
        System.out.println("Username:");
        userInput = sc.nextLine();
        newPerson.setUserName(userInput);
        System.out.println("New Tenant:");
        displayPerson(newPerson);
    }

        private static void displayPerson(Person person) {
            System.out.printf("""
                    Tenant %s %s
                    ------------------------------
                    Id: %d
                    First Name:%s
                    Last Name:%s
                    User Name:%s
                        
                    """,
            person.getFirstName(),
            person.getLastName(),

            person.getId(),
            person.getFirstName(),
            person.getLastName(),
            person.getUserName());
        }

    private static void displayAllPersons() {

            for (int i=1; i<=PersonDB.viewNextId(); i++ ) {

                Person person = PersonDB.getPerson(i);
                System.out.printf("""
                    Tenant %s %s
                    ------------------------------
                    Id: %d
                    First Name:%s
                    Last Name:%s
                    User Name:%s
                        
                    """,
                person.getFirstName(),
                person.getLastName(),

                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getUserName());
            }
    }

        private static void displayApartment(Apartment apartment) {
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Apartment ID: \t\t" + apartment.getId() +
                    "\n\tLocation\t\t" + apartment.getLocation() +
                    "\n\tApartment #\t\t" + apartment.getApartmentNum() +
                    "\n\tSquare Feet\t" + apartment.getSquareFeet() +
                    "\n\tPrice\t\t\t" + currency.format(apartment.getPrice()) +
                    "\n\tTenant\t\t\t" + apartment.getTenant()
            );
        }


        private static void displayTotals(Apartment apartment1, Apartment apartment2) {
            int squareFeetTotal = apartment1.getSquareFeet() + apartment2.getSquareFeet();
            double priceTotal = apartment1.getPrice() + apartment2.getPrice();

            System.out.println(
                "Square Feet Total: " + squareFeetTotal
                + "\nPrice Total: " + priceTotal
            );

        }

}

