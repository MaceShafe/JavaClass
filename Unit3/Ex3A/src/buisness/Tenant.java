package buisness;



public class Tenant extends Person{

    private double currentBalance;

    public Tenant (int personID, String firstName, String lastName, String userName,
                   double currentBalance) {
        super(personID, firstName, lastName, userName);
        this.currentBalance = currentBalance;
    }



}
