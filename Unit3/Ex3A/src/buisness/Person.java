package buisness;

import data.PersonDB;

import java.time.LocalDateTime;

public class Person extends BuisnessEntity {
    private int personId;
    private String firstName;
    private String lastName;
    private String userName;


    public Person(int id, LocalDateTime creationDate,
                  String firstName, String lastName, String userName, int personId) {
    }

    public Person() {
        this.personId = PersonDB.getNextId();
        this.firstName = "unknown";
        this.lastName = "unknown";
        this.userName = "unknown";    }

    public Person(int id, String firstName, String lastName, String userName) {
        this.personId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public Person (int id) {
        this.personId = id;
    }

    public Person(Person person) {
        this.personId = PersonDB.getNextId();
        this.firstName = person.firstName;
        this.lastName = person.lastName;
        this.userName = person.userName;
    }

    //getters and setters


    public int getPersonId() {
        return personId;
    }

//    public void setId(int id) {
//        Id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    @Override
    public String toString() {

        return super.toString() + "Person{" +
                "Id=" + personId +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", UserName='" + userName + '\'' +
                "} " + super.toString();
    }
}



