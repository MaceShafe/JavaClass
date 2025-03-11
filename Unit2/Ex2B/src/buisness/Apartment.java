package buisness;

import data.PersonDB;

public class Apartment {
    private double price;
    private int Id;
    private Building location;
    private String apartmentNum;
    private Person Tenant;
    private int squareFeet;



    public Apartment() {
        this(
                PersonDB.getNextId(),
                null,
                "unknown",
                0,
                0
        );

    }


    public Apartment(int id, Building location, String apartmentNum, int squareFeet, double price) {
        this.Id = id;
        this.location = location;
        this.apartmentNum = apartmentNum;
        this.squareFeet = squareFeet;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
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
        return "buisness.Apartment " + apartmentNum + ":" +
                "\n------------------------------\n" +
                "\nprice:" + price +
                "\nid:" + Id +
                "\nlocation:'" + location +
                "\napartmentNum:'" + apartmentNum + '\'' +
                "\nTenant:" + Tenant.getFirstName() + " " + Tenant.getLastName() +
                "\nsquareFeet:" + squareFeet +
                "\n\n"

                ;
    }
}
