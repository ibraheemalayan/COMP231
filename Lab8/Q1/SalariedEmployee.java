package Lab8.Q1;

public class SalariedEmployee extends Employee{

    private double weekly_salary;

    public SalariedEmployee(String first_name, String last_name, int ID, double weekly_salary) {
        super(first_name, last_name, ID);
        this.weekly_salary = weekly_salary;
    }

    public double getWeekly_salary() {
        return weekly_salary;
    }

    public void setWeekly_salary(double weekly_salary) {
        this.weekly_salary = weekly_salary;
    }

    @Override
    public double earning(){
        return weekly_salary * 4;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ID=" + ID +
                ", weekly_salary=" + weekly_salary +
                '}';
    }
}
