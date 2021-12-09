package Lab7;

public class Checking extends Account{

    public Checking(int id, double balance) {
        super(id, balance);
    }

    public Checking() {
        super();
    }

    @Override
    public void withdraw(double amount) {
        double new_balance = this.balance - amount;

        if (new_balance < -1000){
            System.out.println("Your account has reached the overdraft limit (1000)");
            return;
        }

        this.balance = new_balance;
    }
}
