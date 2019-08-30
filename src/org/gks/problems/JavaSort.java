import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts
     * following parameters: 1. INTEGER month 2. INTEGER day 3. INTEGER year
     */

    static String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

    public static String findDay(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        // c.setTime(yourDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return days[dayOfWeek - 1];
    }

}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        Calendar c = Calendar.getInstance();
        c.set(year, month, date);
        // c.setTime(yourDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, Comparator.comparingDouble(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparingInt(Student::getId));
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
