package Lab7;

import java.util.Date;

public class Account {

    protected int id = 0;
    protected double balance = 0.0;
    private Date dateCreated;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;

        dateCreated = new Date();
    }

    public Account() {
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void withdraw(double amount){
        this.balance -= amount;
    }

    public void deposite(double amount){
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
