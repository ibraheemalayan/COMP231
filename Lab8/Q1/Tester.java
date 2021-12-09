package Lab8.Q1;

public class Tester {

    public static void main(String[] args) {


        Employee arr[] = new Employee[4];

        arr[0] = new SalariedEmployee("Ahmad", "E1", 213322, 1000);
        arr[1] = new HourlyEmployee("Mohammad", "E2", 213322, 30, 40);
        arr[2] = new CommissionEmployee("Ahmad", "E3", 213322, 0.15, 10000);
        arr[3] = new BaseCommissionEmployee("Ahmad", "E4", 213322, 0.12, 10000, 200);

        for (int i = 0; i < 4; i++) {
            System.out.println("\n" + arr[i]);
            System.out.println(arr[i].earning() +"\n");
        }

        System.out.println("\n----------------------------\n");

        Employee.sort(arr);

        for (int i = 0; i < 4; i++) {
            System.out.println("\n" + arr[i]);
            System.out.println(arr[i].earning() +"\n");
        }








    }

}
