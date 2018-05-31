package imit.collections;

public class Student extends Human{
    private String faculty;

    public Student(String faculty) {
        super();
        this.faculty = faculty;
    }

    public Student(String firstName, String middleName, String lastName, int age, String faculty) {
        super(firstName, middleName, lastName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + " faculty='" + faculty + '}';
    }
}
