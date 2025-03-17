package data;

import buisness.Apartment;

public class ApartmentDB {

    public static int nextId = 3;

    public static int getNextId() {
        return nextId++;
    }

    public static int viewNextId() {
        return nextId;
    }

    public static Apartment getApartment(int id) {

        Apartment apartment = null;


        if (id == 1) {

            apartment = new Apartment(1, BuildingDB.getBuildingById(1), "101", 1111, 1111.11);

        }
        if (id == 2) {

            apartment = new Apartment(2, BuildingDB.getBuildingById(1), "102", 1111, 1111.11);


        }
        return apartment;
    }
}
