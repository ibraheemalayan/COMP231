package Lab8.Q1;

public class CommissionEmployee extends Employee{

    private double rate, gross_sales;

    public CommissionEmployee(String first_name, String last_name, int ID, double rate, double gross_sales) {
        super(first_name, last_name, ID);
        this.rate = rate;
        this.gross_sales = gross_sales;
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getGross_sales() {
        return gross_sales;
    }

    public void setGross_sales(double gross_sales) {
        this.gross_sales = gross_sales;
    }

    @Override
    public double earning() {
        return rate*gross_sales;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "rate=" + rate +
                ", gross_sales=" + gross_sales +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
