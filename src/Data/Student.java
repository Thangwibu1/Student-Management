package Data;

public class Student {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private String studentID;
    private String studentName;
    private int yearOfBirth;
    private double gpa;


    public Student() {}
    public Student(String studentID, String studentName, int yearOfBirth, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public double getGpa() {
        return gpa;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("|%8s|%-25s|%4d|%.2f|\n", studentID, studentName, yearOfBirth, gpa);
    }
    public void showProfile() {
        System.out.printf("|%8s|%-25s|%4d|%.2f|\n", studentID, studentName, yearOfBirth, gpa);
    }


}
