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


}
