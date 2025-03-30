package ui;

import buisness.Apartment;
import data.ApartmentDB;

import java.text.NumberFormat;

public class ApartmentsController {

    public static void displayApartment(Apartment apartment) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Apartment ID: \t\t" + apartment.getId() +
                "\n\tLocation\t\t" + apartment.getLocation() +
                "\n\tApartment #\t\t" + apartment.getApartmentNum() +
                "\n\tSquare Feet\t" + apartment.getSquareFeet() +
                "\n\tPrice\t\t\t" + currency.format(apartment.getPrice()) +
                "\n\tTenant\t\t\t" + apartment.getTenant()
        );
    }
    public static void displayAllApartments() {
        for (int i =1; i< ApartmentDB.viewNextId(); i++) {

            Apartment apartment = ApartmentDB.getApartment(i);

            if (apartment != null) {
                displayApartment(apartment);
            }

        }
    }


    private static void displayTotals(Apartment apartment1, Apartment apartment2) {
        int squareFeetTotal = apartment1.getSquareFeet() + apartment2.getSquareFeet();
        double priceTotal = apartment1.getPrice() + apartment2.getPrice();

        System.out.println(
                "Square Feet Total: " + squareFeetTotal
                        + "\nPrice Total: " + priceTotal
        );
    }


    }
