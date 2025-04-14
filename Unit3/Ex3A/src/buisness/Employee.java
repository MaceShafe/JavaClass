package buisness;



public class Employee extends Person{

    private double annualSalary;

    public Employee (int personID, String firstName, String lastName, String userName,
                   double annualSalary) {
        super(personID, firstName, lastName, userName);
        this.annualSalary = annualSalary;
    }



}
