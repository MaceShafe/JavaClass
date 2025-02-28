public class Apartment {
    double price;
    int id;
    String location;
    String apartmentNum;
    Person Tenant;
    int squareFeet;

    public Apartment() {

    }

    public Apartment(double price, int id, String location, String apartmentNum, Person tenant, int squareFeet) {
        this.price = price;
        this.id = id;
        this.location = location;
        this.apartmentNum = apartmentNum;
        Tenant = tenant;
        this.squareFeet = squareFeet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public Person getTenant() {
        return Tenant;
    }

    public void setTenant(Person tenant) {
        Tenant = tenant;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    @Override
    public String toString() {
        return "Apartment " + apartmentNum + ":" +
                "\n------------------------------\n" +
                "\nprice:" + price +
                "\nid:" + id +
                "\nlocation:'" + location +
                "\napartmentNum:'" + apartmentNum + '\'' +
                "\nTenant:" + Tenant.getFirstName() + " " + Tenant.getLastName() +
                "\nsquareFeet:" + squareFeet +
                "\n\n"

                ;
    }
}
