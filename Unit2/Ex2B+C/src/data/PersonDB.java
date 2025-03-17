package data;

import buisness.Person;

public class PersonDB {

    public static int nextId = 3;

    public static Person getPerson(int id) {
    Person person = null;

        if (id == 1) {

        person = new Person(1,"John","Doe","john.doe");

        }
        if (id == 2) {
            person = new Person(2,"Jane","Doe","jane.doe");

        }
        return person;
    }

    public static int getNextId() {
        return nextId++;
    }

    public static int viewNextId() {
        return nextId;
    }


}
