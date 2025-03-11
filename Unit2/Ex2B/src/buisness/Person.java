package buisness;

import data.PersonDB;

public class Person {
    private final int Id;
    private String FirstName;
    private String LastName;
    private String UserName;


    public Person() {
        this.Id = PersonDB.getNextId();
        this.FirstName = "unknown";
        this.LastName = "unknown";
        this.UserName = "unknown";    }

    public Person(int id, String firstName, String lastName, String userName) {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.UserName = userName;
    }


    public Person(Person person) {
        this.Id = PersonDB.getNextId();
        this.FirstName = person.FirstName;
        this.LastName = person.LastName;
        this.UserName = person.UserName;
    }

    //getters and setters


    public int getId() {
        return Id;
    }

//    public void setId(int id) {
//        Id = id;
//    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }



    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}



