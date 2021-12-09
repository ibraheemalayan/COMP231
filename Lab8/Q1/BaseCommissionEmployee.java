package Lab8.Q1;

public class BaseCommissionEmployee extends CommissionEmployee{

    private double base_salary;

    public BaseCommissionEmployee(String first_name, String last_name, int ID, double rate, double gross_sales, double base_salary) {
        super(first_name, last_name, ID, rate, gross_sales);
        this.base_salary = base_salary;
    }

    public double getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(double base_salary) {
        this.base_salary = base_salary;
    }

    @Override
    public double earning() {
        return super.earning() + base_salary;
    }

    @Override
    public String toString() {
        return "BaseCommissionEmployee{" +
                "base_salary=" + base_salary +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
