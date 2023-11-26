package Domain.Dao.Crud;

import Domain.Entity.Course;
import Domain.Entity.Status;
import Domain.Entity.Student;

import java.util.*;
import java.time.LocalDate;

public class academicManager implements academicServicesI{
HashMap<Integer, List<Course>> courseHashMap = new HashMap<>();
Scanner scanner = new Scanner(System.in);
Student students = new Student();
Course courses = new Course();
Services services = new Services();

@Override
    public void addStudent(){
    try {
    System.out.print("Insert Student ID: \n ");
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

        int search = students.getId();

        Optional<Student> searchStudent = services.getStudentList().stream().filter(student -> student.getId() == search).findFirst();
        if (searchStudent.isPresent()){
            System.out.println("El estudiante ya está en la lista.");
//
        } else {
            services.getStudentList().add(new Student(students.getId(),students.getName(), students.getLastName(),students.getdateOfBirth(),students.getStatus()));
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

            student.ifPresent(student1 -> System.out.println("Product:\n" + student1));
        } else {
            System.out.print("el estudiante no se encuentra inscrito: \n");

        }
    }

    @Override
    public void addCourse() {
        try {
            System.out.print("Insert Course ID: \n");
            courses.setId(scanner.nextInt());
            System.out.println("Insert Name: ");
            courses.setName(scanner.next());
            System.out.print("Insert Description: ");
            courses.setDescription(scanner.next());
            System.out.print("Insert Number of Credits: ");
            courses.setCreditsNumber(scanner.next());
            System.out.print("Insert Version: ");
            courses.setVersion(scanner.next());

            int search = courses.getId();

            Optional<Course> searchCourse = services.getCourseList().stream().filter(course -> course.getId() == search).findFirst();
            if (searchCourse.isPresent()){
                System.out.println("El curso ya creado.");
//
            } else {
                services.getCourseList().add(new Course(courses.getId(),courses.getName(),courses.getDescription(),courses.getCreditsNumber(),courses.getVersion()));
                throw new Exception("El curso no está en la lista. Agregando Curso \nEl Curso ha sido agregado");


            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
    @Override
    public void consultCourse() {
        System.out.println("Ingrese el Id del Codigo");

        int idCourse = scanner.nextInt();
        Optional<Course> course = services.getCourseList().stream()
                .filter(market -> market.getId() == idCourse)
                .findFirst();

        if (course.isPresent()) {

            course.ifPresent(course1 -> System.out.println("Course:\n" + course1));
        } else {
            System.out.print("el curso no se encuentra inscrito: \n");

        }
    }


    @Override
    public void enrollStudentCourse(Student students, Course courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Student id");

        students.setId(scanner.nextInt());

        System.out.println("Enter the Course code");
        courses.setId(scanner.nextInt());


        // Verificar si el estudiante ya está en el HashMap
        List<Course> enrolledCourses = courseHashMap.getOrDefault(students.getId(), new ArrayList<>());


        // Agregar el nuevo curso a la lista de cursos del estudiante
        enrolledCourses.add(courses);


        // Actualizar el HashMap con la lista de cursos del estudiante
        courseHashMap.put(students.getId(), enrolledCourses);

        System.out.println(courseHashMap);
        System.out.println("" +".");
    }


    @Override
    public void unsubscribeStudentCourse() {
        try {
            System.out.println("Enter Student ID: ");
            students.setId(scanner.nextInt());
            Optional<Student> SearchName = services.getStudentList().stream().filter(student -> students.getId() == students.getId()).findFirst();
            SearchName.ifPresent(name -> System.out.println(name));
            System.out.println("Enter Course ID: ");
            courses.setId(scanner.nextInt());
            Optional<Course> Search = services.getCourseList().stream().filter(persona -> persona.getId() == persona.getId()).findFirst();
            if (Search.isPresent()) {
                List<Course> enrolledCourses = courseHashMap.getOrDefault(students.getId(), new ArrayList<>());
                enrolledCourses.remove(courses);
                courseHashMap.put(students.getId(), enrolledCourses);
                System.out.println(courseHashMap);
                System.out.println("the student's course was deleted");
            } else {
                throw new Exception("El estudiante no tiene cursos inscritos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
