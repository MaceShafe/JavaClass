/*
The future value app calculates the final investment.
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {

    public static void main(String[] args) {

    //Write a welcome message
        System.out.printf("Welcome to the Future Value Calculator, %s!", System.getProperty("user.name"));
        System.out.println();

    //Capture user input

        Scanner scanner = new Scanner(System.in);
        String choice = "y";

        while(choice.equalsIgnoreCase("y")) {
            String input;


            //Calculate the future value
            System.out.print("Enter monthly investment: ");
            input = scanner.nextLine();
            double monthlyInvestment = Double.parseDouble(input);

            System.out.print("Enter yearly interest rate: ");
            input = scanner.nextLine();
            double yearlyInterestRate = Double.parseDouble(input);

            System.out.print("Enter number of years: ");
            input = scanner.nextLine();
            int years = Integer.parseInt(input);

            double futureValue = 0.0;

            //Calculate the value
            double monthlyInterestRate = yearlyInterestRate / 12 / 100;
            int numberOfMonths = years *12;
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


            for (int i = 0; i < numberOfMonths; i++) {
                futureValue =(futureValue + monthlyInvestment) * (1 + monthlyInterestRate);

                System.out.println("\t Month " + i + " value: " + numberFormat.format( futureValue));
            }

            //display the value
            System.out.println("Future Value: " + numberFormat.format(futureValue));

            //ask if user wants to continue

            System.out.print("Continue? (y/n): ");
            choice = scanner.nextLine();
        }


    }
}
