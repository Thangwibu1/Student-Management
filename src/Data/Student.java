package Data;

public class Student {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private String studentID;
    private String studentName;
    private String yearOfBirth;
    private String gpa;


    public Student() {}
    public Student(String studentID, String studentName, String yearOfBirth, String gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
    public String getGpa() {
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
    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public String getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%8s|%-25s|%-4s|%-4s\n", studentID, studentName, yearOfBirth, gpa);
    }
    public void showProfile() {
        System.out.printf("%8s|%-25s|%-4s|%-4s\n", studentID, studentName, yearOfBirth, gpa);
    }


}
