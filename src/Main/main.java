package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Data.Student;
import Data.Function;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Function fc = new Function();
        while (true) {
            clearScreen();
            int choose = showMenu();
            switch (choose) {
                case 1:
                    fc.readFromFile();
                    fc.display();
                    break;
                case 2:
                    fc.addStudent();
                    fc.saveToFile();
                    break;
                case 3:
                    fc.readFromFile();
                    fc.deleteStudent();
                    fc.saveToFile();
                    break;
                case 4:
                    fc.readFromFile();
                    fc.findStudent();
                    break;
                case 0:
                    System.out.println("Bye Bye!");
                    return;
                default:
                    System.out.println("Error!");
                    break;
            }
            System.out.print("Do you want continue?(y/n): ");
            String checkContinue = sc.nextLine();
            boolean is_continue = false;
            if (checkContinue.equals("y")) {
                is_continue = true;
            } else if (checkContinue.equals("n")) {
                is_continue = false;
            }

            if (!is_continue) {
                System.out.println("Bye Bye!");
                return;
            }
        }
    }

    public static int showMenu() {
        System.out.println("========MENU========");
        System.out.println("1. Show list of student.");
        System.out.println("2. Add new student.");
        System.out.println("3. Delete student.");
        System.out.println("4. Student exist check.");
        System.out.println("0. Close program");
        System.out.print("Enter your choice: ");

        int choose;
        Scanner sc = new Scanner(System.in);
        choose = sc.nextInt();
        while (choose < 0 || choose > 4) {
            System.out.println("Invalid choice!");
            System.out.print("Enter your choice again: ");
            choose = sc.nextInt();
        }

        return choose;

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
