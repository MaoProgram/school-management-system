package Domain.Dao.Crud;

import Domain.Entity.Course;
import Domain.Entity.Status;
import Domain.Entity.Student;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class academicManager implements academicServicesI{

private List<Student> studentsList;
Scanner scanner = new Scanner(System.in);
Student students = new Student();
Course courses = new Course();
Services services = new Services();

@Override
    public void addStudent(){
    try {
    System.out.print("Insert Student ID\nNew Student: ");
    students.setId(scanner.nextInt());
    System.out.println("Insert Name: ");
    students.setName(scanner.next());
    System.out.print("Insert Last Name: ");
    students.setLastName(scanner.next());
    System.out.print("Insert Date Of Birth: YYYY-MM-DD ");
    String dateOfBirthString = scanner.next();
    LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
    students.setdateOfBirth(dateOfBirth);
    System.out.print("Insert a State: \n");
    int index=1;
    for (Status status : Status.values()) {
        System.out.println(index+") "+status);
        index++;
    }
    students.setStatus(scanner.next());

    //students.setId(scanner.nextInt());
        int search = students.getId();

        Optional<Student> searchStudent = services.getStudentList().stream().filter(student -> student.getId() == search).findFirst();
        if (searchStudent.isPresent()){
            System.out.println("El estudiante ya está en la lista.");
//
        } else {
            services.getStudentList().add(new Student(students.getId(), students.getName(), students.getLastName(), students.getdateOfBirth(), students.getStatus()));
            throw new Exception("El estudiante no está en la lista. Agregando estudiante \nEl estudiante ha sido agregado");


        }
    } catch (Exception e) {

        System.out.println(e.getMessage());
    }
}

    @Override
    public void consultStudent() {
        System.out.println("Ingrese el Id del estudiante");

        int idStudent = scanner.nextInt();
        Optional<Student> student = services.getStudentList().stream()
                .filter(market -> market.getId() == idStudent)
                .findFirst();

        if (student.isPresent()) {

            student.ifPresent(products1 -> System.out.println("Product:\n" + products1));
        } else {
            System.out.print("el estudiante no se encuentra inscrito: \n");


        }
    }

    @Override
    public void addCourse() {

    }

    @Override
    public void enrollStudentCourse() {

    }

    @Override
    public void unsubscribeStudentCourse() {

    }
}
