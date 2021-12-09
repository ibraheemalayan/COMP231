package Lab5;

import java.util.Date;

public class Employee_Tester {

    public static void main(String[] args) {

        Employee[] emps = new Employee[4];

        emps[0] = new Employee(1,"rami",23,new Date(), new Date(), 1200.0);
        emps[1] = new Employee(1,"rami",43,new Date(), new Date(), 1600.0);
        emps[2] = new Employee(2,"rami",63,new Date(), new Date(), 1100.0);
        emps[3] = new Employee(4,"rami",73,new Date(), new Date(), 14400.0);

        largestSalary(emps).printEmployeeInfo();

    }

    public static Employee largestSalary ( Employee [ ] employees){

        Employee largest_emp = employees[0];

        for (int i = 1; i < 4; i++) {

            if (largest_emp.getBasicSalary() < employees[i].getBasicSalary()){
                largest_emp = employees[i];
            }

        }

        return largest_emp;
    }


}
