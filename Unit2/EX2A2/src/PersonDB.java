public class PersonDB {

    public static Person getPerson(int id) {
    Person person = new Person(id);

        if (id == 1) {
            person.setFirstName("John");
            person.setLastName("Doe");
            person.setUserName("john.doe");
        }
        if (id == 2) {
            person.setFirstName("Jane");
            person.setLastName("Doe");
            person.setUserName("jane.doe");
        }
        return person;
    }
}
