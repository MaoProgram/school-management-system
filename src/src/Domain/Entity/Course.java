package Domain.Entity;

import java.util.List;

public class Course {
    private List<Course> courseList;


    public List<Course> getCourseList() {
        return courseList;
    }
    private int id;
    private String name;
    private String description;
    private String creditsNumber;
    private String version;

    public Course() {

    }

    public Course(int id, String name, String description, String creditsNumber, String version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creditsNumber = creditsNumber;
        this.version = version;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreditsNumber() {
        return creditsNumber;
    }

    public void setCreditsNumber(String creditsNumber) {
        this.creditsNumber = creditsNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
