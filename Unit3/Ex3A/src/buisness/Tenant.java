package buisness;
import java.time.LocalDateTime;



public class Tenant extends Person{

    private double currentBalance;

    public Tenant (int personID, LocalDateTime CreationDate, String firstName, String lastName, String userName,
                   double currentBalance) {
        super(personID, CreationDate, firstName, lastName, userName);
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
