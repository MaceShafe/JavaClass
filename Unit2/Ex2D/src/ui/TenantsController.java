package ui;

import buisness.Person;
import data.PersonDB;

import java.util.Scanner;

public class TenantsController {


    public static void displayPerson(Person person) {
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

    public static void displayPerson() {
        System.out.printf("Please enter the Tenant ID");
        boolean validId = false;

        while (!validId) {
            Scanner sc = new Scanner(System.in);
            try {
                Person person = PersonDB.getPerson(sc.nextInt());
                displayPerson(person);
                validId = true;
                System.out.println("ID is valid!");
            } catch (Exception e) {
                System.out.println("ID is not valid! Input ID again!");
            }

        }
    }

    public static void displayAllPersons() {

        for (int i = 1; i<= PersonDB.viewNextId(); i++ ) {

            Person person = PersonDB.getPerson(i);

            if (person != null){
                displayPerson(person);
            }
        }
    }

    public static void registerPerson() {

        Person newPerson = new Person();
        Scanner sc = new Scanner(System.in);
        ;
        boolean isValid = false;
        String userInput = null;
        String fName = null, lName = null;

        while (!isValid) {
            System.out.println("User First Name:");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 12);
            if (!isValid) {
                System.out.println("Text must be under 12 characters and not empty.");
            }
        }
        isValid = false;
        newPerson.setFirstName(userInput);

        while (!isValid) {
            System.out.println("User Last Name:");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 12);
            if (!isValid) {
                System.out.println("Text must be under 12 characters and not empty.");
            }
        }
        isValid = false;
        newPerson.setLastName(userInput);
        while (!isValid) {
            System.out.println("Username (if blank, will default to " + newPerson.getFirstName() + "." + newPerson.getLastName() + "." +newPerson.getId() + "):");
            userInput = sc.nextLine();
            isValid = isCharacterLimitReached(userInput, 50);
            if (!isValid) {
                userInput =  newPerson.getFirstName() + "." + newPerson.getLastName () + "." +newPerson.getId();
                isValid = true;
            }
        }
        newPerson.setUserName(userInput);

        System.out.println("New Tenant:");
        displayPerson(newPerson);
        System.out.println("NOTE: This is currently non-functional and not writing to an array nor file, \n the next assignment is the one that says to do that if I'm correct");
    }



public static boolean isCharacterLimitReached(String text, int length)  {
        if (text.length()>length || text.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
}
