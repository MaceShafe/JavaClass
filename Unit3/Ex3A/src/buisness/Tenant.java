package buisness;



public class Tenant extends Person{

    private double currentBalance;

    public Tenant (int personID, String firstName, String lastName, String userName,
                   double currentBalance) {
        super(personID, firstName, lastName, userName);
        this.currentBalance = currentBalance;
    }
    public Tenant () {

    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "currentBalance=" + currentBalance +
                '}';
    }
}
