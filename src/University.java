import java.io.*;
import java.util.ArrayList;

public class University {
    private ArrayList<Student> studentList;
    private String filePath;
    public University(String filePath) {
        this.filePath = filePath;
        this.studentList = loadStudents();
    }
    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }
    public void listStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(i + ": " + studentList.get(i).getStudentNumber() + ": " + studentList.get(i).getName());
        }
    }
    public void saveStudent() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Student cannot be saved to the file");
        }
    }
    public ArrayList<Student> loadStudents() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        ArrayList<Student> loadedStudent = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            loadedStudent = (ArrayList<Student>) objectInputStream.readObject();
            objectInputStream.close();

        } catch(Exception e) {
            System.out.println("Error loading from the file" + " " + e);
            return new ArrayList<>();
        }
        return loadedStudent;
    }
    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }
}

