package Lab8.Q1;

public class HourlyEmployee extends Employee{

    private double wage, hours_worked;

    public HourlyEmployee(String first_name, String last_name, int ID, double wage, double hours_worked) {
        super(first_name, last_name, ID);
        this.wage = wage;
        this.hours_worked = hours_worked;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(double hours_worked) {
        this.hours_worked = hours_worked;
    }

    @Override
    public double earning() {
        return wage * hours_worked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ID=" + ID +
                ", wage=" + wage +
                ", hours_worked=" + hours_worked +
                '}';
    }
}
