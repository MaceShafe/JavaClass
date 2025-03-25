package data;

import buisness.Person;
import java.io.*;

import java.util.ArrayList;

public class PersonDB {

    Person person = null;

    public static int nextId = 3;

    public static Person getPerson(int id) {

        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i));
        }
        return person;
    }

    public static void readLines() throws IOException {
        String filename = "tenants.txt";

        File file = new File(filename);
        System.out.println("Reading from: " + file.getAbsolutePath());


//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));


        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String id = fields[0];
                String fName = fields[1];
                String lName = fields[2];
                String uName = fields[3];
                Person person = new Person(Integer.parseInt(id),fName,lName,uName);

                System.out.println("Read from tenants.txt: " + person);
                line = in.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
//        ArrayList<Person> People = new ArrayList<Person>();
//            People.add(new Person(1,"John","Doe","john.doe"));

//        return false;
    }

    public static int getNextId() {
        return nextId++;
    }

    public static int viewNextId() {
        return nextId;
    }


}
