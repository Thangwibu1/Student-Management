package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Function {
    public String id;
    public String name;
    public String yob;
    public String gpa;
    private List<Student> sList;
    Scanner sc = new Scanner(System.in);

    // Defined arrayList
    public Function() {
        sList = new ArrayList<>();
    }

    // Read file (start)
    public void readFromFile() throws IOException {
        sList.clear();
        File f = new File("data.txt");
        if (!f.exists()) {
            System.out.println("New file already created");
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String info[] = line.split("[|]");
            id = info[0].trim();
            name = info[1].trim();
            yob = info[2].trim();
            gpa = info[3].trim();

            sList.add(new Student(id, name, yob, gpa));
        }

        br.close();
        fr.close();
    }

    public void display() {
        clearScreen();
        if (sList.isEmpty()) {
            System.out.println("Don't have student! PLease add something!");
            return;
        }
        for (Student student : sList) {
            System.out.print(student);
        }
    }
    // Read document (end)

    // Write document to file(start)
    public void addStudent() {
        clearScreen();
        System.out.print("Enter your student ID: ");
        id = sc.nextLine();
        loop: do {
            System.out.println("Your student ID need at least 8 char and must have 'se' in first place letter!");
            System.out.print("Enter student ID again: ");
            id = sc.nextLine();
            String tmp1 = ""; 
            tmp1 += id.charAt(0);
            String tmp2 = ""; 
            tmp2 += id.charAt(1);
            if (tmp1.equals("s") && tmp2.equals("e")) {
                break;
            } else {
                continue loop;
            }
        } while (id.length() != 8);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your year of birth: ");
        yob = sc.nextLine();
        while (Integer.parseInt(yob) > 2024 || Integer.parseInt(yob) < 1) {
            System.out.println("Your year of birth is invalid, please enter again!");
            System.out.print("Enter your yob again: ");
            yob = sc.nextLine();
        }
        System.out.print("Enter your gpa: ");
        gpa = sc.nextLine();
        while (Double.parseDouble(gpa) > 4.0 || Double.parseDouble(gpa) < 0.0) {
            System.out.println("Your year of birth is invalid, please enter again!");
            System.out.print("Enter your gpa again: ");
            gpa = sc.nextLine();
        }
        sList.add(new Student(id, name, yob, gpa));

        System.out.println("Add student information sucessfull");
    }

    public void saveToFile() throws IOException {
        File f = new File("data.txt");
        FileWriter fr = new FileWriter(f);
        BufferedWriter br = new BufferedWriter(fr);
        for (Student student : sList) {
            br.write(student.toString());
        }
        br.close();
        fr.close();
    }
    // Write document(end)

    // Delete information
    public void deleteStudent() {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        id = sc.nextLine();
        boolean studentFind = false;

        // Use an iterator to safely remove an item from the list during iteration
        Iterator<Student> iterator = sList.iterator(); //=> Mảng iterator được cấp phép thay đổi dữ liệu từ mảng sList 
        while (iterator.hasNext()) {
            Student s = iterator.next(); //Lấy phần tử trong iterator ra
            if (id.equals(s.getStudentID())) {
                iterator.remove();
                System.out.println("Student " + id + " has been removed.");
                studentFind = true;
                break;
            }
        }
        if (!studentFind) {
            System.out.println("Student not found.");
        }

    }
    //Delete information(end)
    
    //Find student
    public void findStudent() {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        boolean studentFind = false;
        System.out.print("Enter student ID to find: ");
        id = sc.nextLine();

        Iterator<Student> iterator = sList.iterator();
        //=> Mảng iterator được cấp phép thay đổi dữ liệu từ mảng sList 
        while (iterator.hasNext()) {
            Student s = iterator.next(); //Lấy phần tử trong iterator ra
            if (id.equals(s.getStudentID())) {
                System.out.println(s);
                studentFind = true;
                break;
            }
        }
        if (!studentFind) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student exist.");
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
