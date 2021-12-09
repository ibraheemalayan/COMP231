package Lab7;

public class Saving extends Account{

    public Saving(int id, double balance) {
        super(id, balance);
    }

    public Saving() {
        super();
    }

    @Override
    public void withdraw(double amount) {
        double new_balance = this.balance - amount;

        if (new_balance < 0){
            System.out.println("Your funds are insufficient to complete this withdraw");
            return;
        }

        this.balance = new_balance;
    }
}
