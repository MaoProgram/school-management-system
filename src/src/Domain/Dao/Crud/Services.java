package Domain.Dao.Crud;

import Domain.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Services {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public Services() {
        studentList = new ArrayList<>();
    }


    Student students = new Student();
    //Scanner impresion = new Scanner(System.in);


}