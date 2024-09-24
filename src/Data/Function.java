package Data;

import java.util.Scanner;

public class Function extends Student {
    public String id;
    public String name;
    public int yob;
    public double gpa;
    Scanner sc = new Scanner(System.in);

    public void addStudent(Student students[], int size) {
        clearScreen();
        int newSize = size + 1;
        System.out.print("Enter your student ID: ");
        id = sc.nextLine();
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your year of birth: ");
        yob = sc.nextInt();
        System.out.print("Enter your gpa: ");
        gpa = sc.nextDouble();

        Student tmpStudent = new Student(id, name, yob, gpa);
        Student tmpArray[] = new Student[newSize];
        for (int i = 0; i < students.length; i++) {
            tmpArray[i] = students[i];
            students[i] = null;
        }
        tmpArray[size] = tmpStudent;
        students = tmpArray;
        size++;
        System.out.println(students[size - 1]);
        System.out.println(size);
        System.out.println("Add student information sucessfull");
    }

    public int returnSize(int size) {
        return size + 1;
    }

    public void printStudent(Student students[]) {
        clearScreen();
        System.out.println(students.length);
        if (students.length == 0) {
            System.out.println("Don't have student. Please add one or more. ");
        } else {
            for (int i = 0; i < students.length; i++) {
                System.out.println(students[i]);
            }
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
