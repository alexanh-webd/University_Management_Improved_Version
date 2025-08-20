import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University("Test.ser");
        Calculator calculator = new Calculator();
        ArrayList<Student> mainStudentList = new ArrayList<>();
        while (true) {
            // TODO: Display the menu
            System.out.println("----------------MENU----------------");
            System.out.println("1) Add student");
            System.out.println("2) List students");
            System.out.println("3) Add course completion for student");
            System.out.println("4) List course completion of student");
            System.out.println("5) Calculate the average of course completions");
            System.out.println("6) Calculate median of course completions");
            System.out.println("7) Save students to file");
            System.out.println("8) Load students from file");
            System.out.println("0) End the program");
            String userChoice = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(userChoice);
                if (choice == 0) {
                    // TODO: Break condition for while loop
                    System.out.println("Thank you for using the program");
                    break;

                }
                switch (choice) {
                    case 1:
                        // TODO: Add student info to student list
                        System.out.println("What is the name of the student?");
                        String name = scanner.nextLine();
                        System.out.println("What is the student number of the student?");
                        String studentNumber = scanner.nextLine();
                        Student student = new Student(name, studentNumber);
                        mainStudentList.add(student);
                        break;

                    case 2:
                        // TODO: Show all student in the list
                        if (mainStudentList.isEmpty()) {
                            System.out.println("No student to show!!!");
                        }
                        else {
                            for (int i = 0; i < mainStudentList.size(); i++) {
                                System.out.println(i + ": " + mainStudentList.get(i).getStudentNumber() + ": " + mainStudentList.get(i).getName());
                            }
                            break;
                        }
                        break;

                    case 3:
                        // TODO: Add course and grade to the correspondng student
                        if (mainStudentList.isEmpty()) {
                            System.out.println("No student to implement!!!");
                        }
                        else {
                            for (int i = 0; i < mainStudentList.size(); i++) {
                                System.out.println(i + ": " + mainStudentList.get(i).getStudentNumber() + ": " + mainStudentList.get(i).getName());
                            }
                            System.out.println("Which student?");
                            String studentChoice = scanner.nextLine();
                            try {
                                int studentChoiceInt = Integer.parseInt(studentChoice);

                                System.out.println("What is the name of the course?");
                                String courseName = scanner.nextLine();
                                System.out.println("What is the grade of the course?");
                                String courseGrade = scanner.nextLine();
                                try {
                                    int courseGradeToInt = Integer.parseInt(courseGrade);
                                    if (courseGradeToInt < 0) {
                                        System.out.println("Grade should be positive");
                                    } else {
                                        mainStudentList.get(studentChoiceInt).addGrade(courseName, courseGradeToInt);
                                    }
                                } catch(NumberFormatException e) {
                                    System.out.println("Grade should be an integer: " + e);
                                }
                            } catch(Exception e) {
                                System.out.println("Out of choice!");
                            }
                            break;
                        }
                        break;

                    case 4:
                        // TODO: list course completion of student
                        if (mainStudentList.isEmpty()) {
                            System.out.println("No student to implement!!!");
                        }
                        else {
                            for (int i = 0; i < mainStudentList.size(); i++) {
                                System.out.println(i + ": " + mainStudentList.get(i).getStudentNumber() + ": " + mainStudentList.get(i).getName());
                            }
                            System.out.println("Which student?");
                            String studentChoiceC4 = scanner.nextLine();
                            try {
                                int studentChoiceInt = Integer.parseInt(studentChoiceC4);
                                mainStudentList.get(studentChoiceInt).getGrades();
                            } catch(Exception e) {
                                System.out.println("Invalid student choice");
                            }
                            break;
                        }
                        break;

                    case 5:
                        // TODO: calculate average
                        if (mainStudentList.isEmpty()) {
                            System.out.println("No student to implement!!!");
                        }
                        else {
                            for (int i = 0; i < mainStudentList.size(); i++) {
                                System.out.println(i + ": " + mainStudentList.get(i).getStudentNumber() + ": " + mainStudentList.get(i).getName());
                            }
                            System.out.println("Which student?");
                            String studentChoiceC5 = scanner.nextLine();
                            try {
                                int studentChoiceInt = Integer.parseInt(studentChoiceC5);
                                System.out.println("Average is: " + calculator.getAverageGrade(mainStudentList.get(studentChoiceInt)));
                            } catch(Exception e) {
                                System.out.println("Invalid student choice");
                            }
                            break;
                        }
                        break;

                    case 6:
                        // TODO: calculate median
                        if (mainStudentList.isEmpty()) {
                            System.out.println("No student to implement!!!");
                        }
                        else {
                            for (int i = 0; i < mainStudentList.size(); i++) {
                                System.out.println(i + ": " + mainStudentList.get(i).getStudentNumber() + ": " + mainStudentList.get(i).getName());
                            }
                            System.out.println("Which student?");
                            String studentChoiceC6 = scanner.nextLine();
                            try {
                                int studentChoiceInt = Integer.parseInt(studentChoiceC6);
                                System.out.println("Median is: " + calculator.getMedianGrade(mainStudentList.get(studentChoiceInt)));
                            } catch(Exception e) {
                                System.out.println("Invalid student choice");
                            }
                            break;
                        }
                        break;

                    case 7:
                        // TODO: save students to file
                        for (Student s : mainStudentList) {
                            university.addStudent(s);
                        }
                        university.saveStudent();
                        break;

                    case 8:
                        // TODO: load students from file
                        //university.getStudentList().clear();
                        mainStudentList.clear();
                        System.out.println(mainStudentList);
                        mainStudentList.addAll(university.loadStudents());
                        System.out.println(mainStudentList);
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch(NumberFormatException e) {
                System.out.println("Choice should be a number" + e);
            }
        }
    }
}
