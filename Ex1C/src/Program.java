/*
        This program lets us calculate the
        average temperature of a given sensor.
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("EX1C Temperature Monitor");

        //Var declaration

        int customerId= 101;
        String customerFirstNamae = "John";
        String customerLastNamae = "Doe";
        int thermometerSensorId= 1001;
        String input;


        //Temperature Readings

        int time1 = 0;
        int time2 = 10;
        int time3 = 20;
        int time4 = 30;
        int time5 = 50;

        System.out.print("Enter Temperature at this time:" + time1 );
        System.out.println();

        input = sc.nextLine();

        int temp1= Integer.parseInt(input);
        System.out.print("Enter Temperature at this time:" + time2 );
        System.out.println();

        input = sc.nextLine();

        int temp2= Integer.parseInt(input);
        System.out.print("Enter Temperature at this time:" + time3 );
        System.out.println();

        input = sc.nextLine();

        int temp3= Integer.parseInt(input);
        System.out.print("Enter Temperature at this time:" + time4 );
        System.out.println();

        input = sc.nextLine();

        int temp4= Integer.parseInt(input);
        System.out.print("Enter Temperature at this time:" + time5 );
        System.out.println();

        input = sc.nextLine();

        //int temp5= Integer.parseInt(input);
        //temp 5 is never used with how this is done

        int timeTemp1 =0; //this one is generally useless, however i have it here so that it lines up with the excel spreadsheet shown in the video.
        int timeTemp2 = (time2-time1) *temp1;
        int timeTemp3 = (time3-time2) *temp2;
        int timeTemp4 = (time4-time3) *temp3;
        int timeTemp5 = (time5-time4) *temp4;


        //Calculate Avg Temp

        double averageTemperature = (double)(timeTemp1+timeTemp2+timeTemp3+timeTemp4+timeTemp5) / time5;

        //print customer info and calc.
        System.out.println("Customer: " + customerId + ". " + customerFirstNamae + " " + customerLastNamae );
        System.out.println("Thermometer: " + thermometerSensorId);
        System.out.println("Average Temperature: " + averageTemperature);

    }
}
