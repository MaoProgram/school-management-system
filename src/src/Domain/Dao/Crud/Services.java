package Domain.Dao.Crud;

import Domain.Entity.Course;
import Domain.Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Services {

    private List<Student> studentList;

    private List<Course> courseList;
    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Course> getCourseList() {return courseList;}

    public Services() {
        studentList = new ArrayList<>();
    }



}