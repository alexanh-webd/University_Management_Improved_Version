import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {
    public double getAverageGrade(Student student) {
        HashMap<String, Integer> studentGrade = student.getCourseList();
        ArrayList<Integer> gradeList = new ArrayList<>();
        for (String course : studentGrade.keySet()) {
            gradeList.add(studentGrade.get(course));
        }
        if (gradeList.size() == 0) {
            return 0;
        }
        Integer s = 0;
        for (int i = 0; i < gradeList.size(); i++) {
            s = s + gradeList.get(i);
        }
        return s/gradeList.size();
    }
    public double getMedianGrade(Student student) {
        HashMap<String, Integer> studentGrade = student.getCourseList();
        ArrayList<Integer> gradeList = new ArrayList<>();
        for (String course : studentGrade.keySet()) {
            gradeList.add(studentGrade.get(course));
        }
        if (gradeList.size() % 2 != 0) {
            return gradeList.get((gradeList.size() + 1)/2 - 1);
        }
        return (gradeList.get(gradeList.size()/2) + gradeList.get(gradeList.size()/2 - 1)) / 2;
    }
}
