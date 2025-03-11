package data;

import buisness.Apartment;

public class ApartmentDB {

    public static Apartment getApartment(int id) {

        Apartment apartment = null;

        if (id == 1) {

            apartment = new Apartment(1, "123 Main Rd", "101", 1111, 1111.11);

        }
        if (id == 2) {

            apartment = new Apartment(2, "123 Main Rd", "102", 1111, 1111.11);


        }
        return apartment;
    }
}
