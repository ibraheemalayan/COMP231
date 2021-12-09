package Lab8.Q2;

import Lab8.Q1.Employee;

public abstract class Shape implements Comparable{

    private String color;
    private boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public abstract double getArea();

    @Override
    public int compareTo(Object o) {

        if ( ((Shape) o).getArea() > this.getArea()){
            return -1;
        }

        if ( ((Shape) o).getArea() < this.getArea()){
            return 1;
        }

        return 0;
    }

    public static void sort(Object[] a){

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if ( ((Shape) a[j]).compareTo((Shape) a[j+1]) == 1 ){
                    Object temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

    }
}
