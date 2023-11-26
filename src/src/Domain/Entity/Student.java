package Domain.Entity;

import java.time.LocalDate;
import java.util.List;

public class Student {

    private List<Student> studentsList;
    public List<Student> getStudentsList() {
        return studentsList;
    }
    private int id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String status;

    public Student(int id, String name, String lastName, LocalDate dateOfBirth, String status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() +
                "\nName: " + this.getName() +
                "\nLastName: " + this.getLastName() +
                "\nDate of Birth: " + this.getdateOfBirth() +
                "\nStatus: " + this.getStatus();
    }
}
