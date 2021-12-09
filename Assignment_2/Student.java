package Assignment_2;

import java.util.Date;
import java.util.Locale;

public class Student {

//    first name, last name, id, date of birth, grade,email
    private String first_name, last_name;
    private int id;
    private double grade;
    private Date birth_date;

    public String getEmail(){
        return (first_name.charAt(0) + last_name + "@ritaj.birzeit.edu").toLowerCase();
    }

    // constructor using all fields
    public Student(String first_name, String last_name, int id, double grade, Date birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.grade = grade;
        this.birth_date = birth_date;
    }

    // constructor using full name
    public Student(String full_name, int id) {

        this.first_name = full_name.split(" ")[0];
        this.last_name = full_name.split(" ")[1];
        this.id = id;
        this.grade = 0;
        this.birth_date = new Date();
    }

    public String getFull_name() {
        return first_name + " " + last_name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name + ", " + getEmail() + ", " + grade + "\n";
    }
}
