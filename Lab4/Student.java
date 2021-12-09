package Lab4;

public class Student {

    private int studentId;
    private String studentName;
    private double grade;

    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int Givenage) {

        if (Givenage > 0){
            System.out.println("age cannot be negative");

        }else{
            this.age = Givenage;
        }

    }

    public Student() { }

    public Student(int stId, String stName, double grade) {
        studentId = stId;
        studentName = stName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {

        this.grade = grade;
    }

    public void setStudentId(int number) {
        studentId = number;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                '}';
    }
}