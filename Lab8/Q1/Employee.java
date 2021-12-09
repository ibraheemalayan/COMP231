package Lab8.Q1;

public abstract class Employee {

    protected String first_name, last_name;
    protected int ID;

    public Employee(String first_name, String last_name, int ID) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract double earning();

    public int compareTo(Employee e){

        if( e.earning() > this.earning() ){
            return -1;
        }
        if( e.earning() < this.earning() ){
            return 1;
        }
        return 0;

    }

    public static double totalEarning(Employee[] arr){

        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].earning();
        }

        return sum;

    }

    public static void sort(Object[] a){

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if ( ((Employee) a[j]).compareTo((Employee) a[j+1]) == 1 ){
                    Object temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

    }
}
