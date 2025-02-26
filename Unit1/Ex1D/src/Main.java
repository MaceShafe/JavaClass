
import java.text.DecimalFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {

    public static void main(String[] args) {
        /// defining variables
        String input;
        int accountNumber = 0;
        String firstName = "";
        String lastName = "";
        int monthlyIncome =0;
        int rentCost = 0;
        int electricCost = 0;
        int gasCost = 0;
        int cableCost = 0;
        int totalCost;
        int incomeMinusExpenses;

            Scanner sc = new Scanner(System.in);


        DecimalFormat formatter = new DecimalFormat("$#,##0.00");


        ///  Used for knowing if its before or after the time the offices are open (12-5)
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("H");
        int formattedTime = Integer.parseInt(time.format(timeformat));

            ///  Grabs today's date and makes "weekdayFormat" into a three character version of the day of the week
        LocalDate today = LocalDate.now();
        DateTimeFormatter weekdayFormat = DateTimeFormatter.ofPattern("E");


            System.out.println("Welcome! Today's Date is " +weekdayFormat+ ", " + today);


        String weekday = today.format(weekdayFormat);
    //    System.out.println(weekday);
            if (weekday.equals("Mon") || weekday.equals("Tue") || weekday.equals("Wed") || weekday.equals("Thu")  && formattedTime >= 12 && formattedTime <= 17 ) {
                System.out.println("The office is open today!");
            } else {
                System.out.println("The office is closed!");
            }
            System.out.println("Office hours are Noon to 5PM!");

        boolean validCheck = false;

        while(!validCheck) {
            System.out.println("Please enter admin username:   ");
                input = sc.nextLine();


                    if (input.equals("admin")) {
                        System.out.println("Welcome!");
                        validCheck = true;
                    }
                }
        System.out.println("Let's start on calculating the tenant's payments,");

            validCheck= false;
            while(!validCheck) {
                System.out.println("Create Tenant First ID:");
                input = sc.nextLine();

                Pattern numberPattern = Pattern.compile("\\d+");
                Matcher matcher = numberPattern.matcher(input);


                if (!matcher.matches()) {
                    System.out.println("Input must be a number");
                } else {
                    validCheck = true;
                    accountNumber = Integer.parseInt(input);
                }
            }


        validCheck= false;
            while(!validCheck) {
                    System.out.println("Tenant First Name:");
                    input = sc.nextLine();
                    if (input.length() >=2) {

                        validCheck = true ;
                        firstName = input;
                        /*I chose less than or equal to two rather than not allowing
                        empty strings to dissuade from anyone putting in a singular
                        space on accident, but also won't disallow it in case if a name
                        isn't necessary or if no name is better.*/
                    }
            }


        validCheck= false;
            while(!validCheck) {
            System.out.println("Tenant Last Name:");
            input = sc.nextLine();
            if (input.length() >=2) {
                        /*I chose less than or equal to two rather than not allowing
                        empty strings to dissuade from anyone putting in a singular
                        space on accident, but also won't disallow it in case if a name
                        isn't necessary or if no name is better.*/
                validCheck = true ;
                lastName = input;}
            }

        validCheck= false;
        while(!validCheck) {
            System.out.println("Insert Tenant Monthly Income:");
            input = sc.nextLine();

            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher matcher = numberPattern.matcher(input);


            if (!matcher.matches()) {
                System.out.println("Input must be a number");
            } else {

                if (Integer.parseInt(input) < 0) {
                    System.out.println("Input must be over zero!");
                } else {
                    validCheck = true;
                    monthlyIncome = Integer.parseInt(input);
                }
            }
        }

        validCheck= false;
        while(!validCheck) {
            System.out.println("Insert monthly rent:");
            input = sc.nextLine();

            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher matcher = numberPattern.matcher(input);


            if (!matcher.matches()) {
                System.out.println("Input must be a number");
            } else {
                if (Integer.parseInt(input) < 0) {
                    System.out.println("Input must be over zero!");
                } else {
                    validCheck = true;
                    rentCost = Integer.parseInt(input);
                }
            }
        }

        validCheck= false;
        while(!validCheck) {
            System.out.println("Insert average monthly electrical cost:");
            input = sc.nextLine();

            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher matcher = numberPattern.matcher(input);


            if (!matcher.matches()) {
                System.out.println("Input must be a number");
            } else {


                if ( Integer.parseInt(input) < 0 ) {
                    System.out.println("Input must be over zero!");
                } else {
                    validCheck = true;
                    electricCost = Integer.parseInt(input);
                }
            }
        }

        validCheck= false;
        while(!validCheck) {
            System.out.println("Insert average monthly gas:");
            input = sc.nextLine();

            if ( Integer.parseInt(input) < 0 ) {
                System.out.println("Input must be over zero!");
            } else {
                validCheck = true;
                gasCost = Integer.parseInt(input);
            }
        }

        validCheck= false;
        while(!validCheck) {
            System.out.println("Insert monthly cable cost:");
            input = sc.nextLine();
            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher matcher = numberPattern.matcher(input);


            if (!matcher.matches()) {
                System.out.println("Input must be a number");
            } else {

                if (Integer.parseInt(input) > 500 || Integer.parseInt(input) < 0) {
                    System.out.println("Input must be over 0 and below 500");
                } else {
                    validCheck = true;
                    cableCost = Integer.parseInt(input);
                }
            }
        }
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println( "Account number: " + accountNumber);

        System.out.println( "Monthly income: " + formatter.format(monthlyIncome));
        System.out.println( "Rent: " + formatter.format(rentCost));
        System.out.println( "Electric: " + formatter.format(electricCost));
        System.out.println( "Gas: " + formatter.format(gasCost));
        System.out.println( "Cable: " + formatter.format(cableCost));
        System.out.println();


        totalCost = rentCost + electricCost + gasCost + cableCost;

        incomeMinusExpenses = monthlyIncome - totalCost;

        System.out.println("Account " + accountNumber + " " + firstName + " " + lastName);
        System.out.println("Income - Expenses: " + formatter.format(monthlyIncome) + " - "+ formatter.format(totalCost) + " = " + formatter.format(incomeMinusExpenses));



    }
}
