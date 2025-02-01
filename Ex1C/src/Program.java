/*
        This program lets us calculate the
        average temperature of a given sensor.
 */

public class Program {
    public static void main(String[] args) {

        System.out.println("EX1C Temperature Monitor");

        //Var declaration

        int customerId= 101;
        String customerFirstNamae = "John";
        String customerLastNamae = "Doe";
        int thermometerSensorId= 1001;

        //Temperature Readings

        //Calculate Avg Temp

        double averageTemperature = 0.0;

        //print customer info and calc.
        System.out.println("Customer: " + customerId + ". " + customerFirstNamae + " " + customerLastNamae );
        System.out.println("Thermometer: " + thermometerSensorId);
        System.out.println("Average Temperature: " + averageTemperature);

    }
}
