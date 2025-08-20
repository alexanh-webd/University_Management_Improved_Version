import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String studentNumber;
    private HashMap<String, Integer> courseList;
    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.courseList = new HashMap<>();
    }
    public String getName() {
        return this.name;
    }
    public String getStudentNumber() {
        return this.studentNumber;
    }
    public void addGrade(String course, int grade) {
        courseList.put(course, grade);
    }
    public void getGrades() {
        for (String course : courseList.keySet()) {
            System.out.println(course + ": " + courseList.get(course));
        }
    }

    public HashMap<String, Integer> getCourseList() {
        return courseList;
    }
}
