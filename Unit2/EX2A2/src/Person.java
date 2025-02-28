public class Person {
    private int Id;
    private String FirstName;
    private String LastName;
    private String UserName;


    public Person(int id) {
        Id = id;
    }

//    public Person(int id, String firstName, String lastName, String userName) {
//        Id = id;
//        FirstName = firstName;
//        LastName = lastName;
//        UserName = userName;
//    }


    //getters and setters


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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
//tostring override, mostly for debug
    @Override
    public String toString() {
        return "Tenant " +FirstName+" "+LastName+ ":" +
                "\n------------------------------" +
                "\nId:" + Id +
                "\nFirst Name:" + FirstName  +
                "\nLast Name:" + LastName  +
                "\nUser Name:" + UserName  +
                '\n';
    }



}



