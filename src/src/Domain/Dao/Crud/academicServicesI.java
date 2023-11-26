package Domain.Dao.Crud;
import Domain.Entity.Course;
import Domain.Entity.Student;
public interface academicServicesI {

    void addStudent();
    void consultStudent();
    void addCourse();
    void consultCourse();
    void enrollStudentCourse(Student students, Course courses);
    void unsubscribeStudentCourse();
}
