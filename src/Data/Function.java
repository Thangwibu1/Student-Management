package Data;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    public String id;
    public String name;
    public int yob;
    public double gpa;
    Scanner sc = new Scanner(System.in);

    public void addStudent(ArrayList<Student> students) {
        clearScreen();
        System.out.print("Enter your student ID: ");
        id = sc.nextLine();
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your year of birth: ");
        yob = sc.nextInt();
        System.out.print("Enter your gpa: ");
        gpa = sc.nextDouble();

        Student tmpStudent = new Student(id, name, yob, gpa);
        ArrayList<Student> tmpArray = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            tmpArray.set(i, students.get(i));
            students.set(i, null);
        }
        tmpArray.add(students.size(), tmpStudent);
        students = tmpArray;
        System.out.println(students.get(0));
        System.out.println(students.size());
        System.out.println("Add student information sucessfull");
    }

    public void printStudent(ArrayList<Student> students) {
        clearScreen();
        System.out.println(students.size());
        if (students.size() == 0) {
            System.out.println("Don't have student. Please add one or more. ");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
