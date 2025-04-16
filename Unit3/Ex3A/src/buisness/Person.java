package buisness;

import data.TenantDB;

import java.time.LocalDateTime;

import static data.TenantDB.getNextId;
import static data.TenantDB.nextId;

public class Person extends BuisnessEntity {
    private String firstName;
    private String lastName;
    private String userName;


    public Person(int Id, LocalDateTime creationDate,
                  String firstName, String lastName, String userName) {
        super(Id, creationDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;

    }

    public Person() {
        this.Id=setId(getNextId());
        this.firstName = "unknown";
        this.lastName = "unknown";
        this.userName = "unknown";    }

    public Person(int id, String firstName, String lastName, String userName) {
        this.Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public Person (int id) {
        this.Id = id;
    }

    public Person(Person person) {
        this.Id = getNextId();
        this.firstName = person.firstName;
        this.lastName = person.lastName;
        this.userName = person.userName;
    }

    //getters and setters


    public int getPersonId() {
        return Id;
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
                "Id=" + Id +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", UserName='" + userName + '\'' +
                "} " + super.toString();
    }
}



