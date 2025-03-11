package buisness;

public class Building {

    private final int id; //final means it can NOT be changed after use

    private String name;
    private Address address;
    private int units;

    //what allows the variables in the individual addresses to be generated

    public Building(int id, String name, Address address, int units) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.units = units;
    }

    //allows outside classes to access the ID but not modify it


//    public int getId() {
//        return id;
//    }

    //allows outside classes to access and MODIFY the ID


//    public int getUnits() {
//        return units;
//    }
//
//    public void setUnits(int units) {
//        this.units = units;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Buiilding{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", units=" + units +
                '}';
    }
}
