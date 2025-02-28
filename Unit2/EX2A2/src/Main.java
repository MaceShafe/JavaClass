public class Main {



        public static void main(String[] args) {

            displayWelcomeMessage();
            Person person1 = PersonDB.getPerson(1);
            System.out.println(person1);
            Person person2 = PersonDB.getPerson(2);
            System.out.println(person2);

            Apartment apartment1 = new Apartment();
            apartment1.setId(1);
            apartment1.setLocation("123 Main Rd");
            apartment1.setApartmentNum("101");
            apartment1.setSquareFeet(1111);
            apartment1.setPrice(1111.11);
            apartment1.setTenant(person1);
            System.out.println(apartment1);

            Apartment apartment2 = new Apartment();
            apartment2.setId(2);
            apartment2.setLocation("123 Main Rd");
            apartment2.setApartmentNum("102");
            apartment2.setSquareFeet(1111);
            apartment2.setPrice(1111.11);
            apartment2.setTenant(person2);
            System.out.println(apartment2);

            displayTotals(apartment1, apartment2);
        }



        private static void displayWelcomeMessage() {
            System.out.println("+ ===================== +\n+ Apartment Manager App +\n+ ===================== +\n");

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

