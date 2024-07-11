package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static final int costOfCourse = 600;
    private static int id = 1000;
    private static Scanner in = new Scanner(System.in);

    public Student() {
        System.out.println("Enter student first name:");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name:");
        this.lastName = in.nextLine();

        System.out.println("1. Freshman\n2. Sophomore\n3. Junior\n4. Senior\nEnter student class level:");
        this.gradeYear = in.nextInt();

        setStudentID();
        System.out.println(this.firstName + " " + this.lastName + " " + this.gradeYear + " " +studentID);
    }

    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = in.next();
            if (!course.equalsIgnoreCase("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance += costOfCourse;
                System.out.println("Enrolled In:" + courses);
            } else {
                System.out.println("Enrollment complete.");
                break;
            }
        } while (true);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
