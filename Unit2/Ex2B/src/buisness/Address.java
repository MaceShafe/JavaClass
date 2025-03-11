package buisness;

public class Address {


    //Init variables

    private final int id;  //final means it can NOT be changed after use

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;


    //what allows the variables in the individual addresses to be generated

    public Address(int id, String street1, String street2, String city, String state, String zipCode) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //allows outside classes to access the ID but not modify it

    public int getId() {
        return id;
    }

    //allows outside classes to access and MODIFY the ID

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
