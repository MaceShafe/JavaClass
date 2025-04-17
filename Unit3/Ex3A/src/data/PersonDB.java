package data;

import buisness.Person;
import java.io.*;

import java.util.ArrayList;

public class PersonDB {

private static final ArrayList<Person> personList = new ArrayList<>();

    public static final String FILE_NAME = "tenants.txt";


    public static int nextId = 1;

    public static void addPerson(Person person) throws IOException {
        personList.add(person);
        nextId++;
        savePersonsToFile();

    }

    public static ArrayList<Person> getAllPersons() {
        return personList;
    }

    public static Person getPersonByID(int id) {

        // create null person that will be modified later

        for (Person person :personList) {
            if (person.getPersonId() == id) {
                return person;
            }
        }

        return null;
    }

    public static void removePerson(Person person)  {
        personList.remove(person);
        savePersonsToFile();

    }

    public static void removePersonByID(int id)  {

        Person personToRemove = getPersonByID(id);
        removePerson(personToRemove);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void loadPersonsFromFile()  {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    String userName = parts[3].trim();

                    PersonDB.addPerson(new Person(id, firstName,lastName,userName));
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME + ", empty tenant file will be created");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage() + ", empty tenant file will be created");
        }
    }

    private static void savePersonsToFile()  {
        try (PrintWriter writer = new PrintWriter( new FileWriter(FILE_NAME))) {
            for (Person person : personList) {
                writer.println(person.getPersonId() + "," + person.getFirstName() + "," + person.getLastName() + "," + person.getUserName());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error saving Tenants");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

}
