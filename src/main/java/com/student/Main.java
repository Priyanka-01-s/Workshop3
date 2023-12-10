package com.student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.student.CourseEnrollment.EnrollmentFailuresException;
import com.student.CourseEnrollment.InvalidCourseException;
import com.student.GradeCalculator.InvalidInputException;
import com.student.GradeCalculator.MissingGradeException;
import com.student.StudentRegistration.DuplicateRegistration;

public class Main {
    public static void main(String[] args) throws com.student.StudentRegistration.InvalidInputException {
        System.out.println("-----WELCOME TO STUDENT GRADING MANAGEMENT SYSTEM-------!");

        Scanner sc = new Scanner(System.in);

        StudentRegistration studentRegistration = new StudentRegistration();
        CourseEnrollment courseEnrollment = new CourseEnrollment();
        GradeCalculator gradeCalculator = new GradeCalculator();

        try{
        boolean continueRegistration = true;

        do{
            System.out.println("----------ENTER THE STUDENT DETAILS-------");
            System.out.println("Enter the student name");
            String name = sc.nextLine();
            System.out.println("Enter the student ID");
            String id = sc.nextLine();
            System.out.println("Enter student email-id");
            String email = sc.nextLine();
            System.out.println("Enter student contact number");
            String phone = sc.nextLine();

            studentRegistration.registedStudent(name, id, email, phone);

            System.out.println("Do you want to register another student? (yes/no)");
            String res = sc.nextLine().toLowerCase();
            continueRegistration = res.equals("yes");


        }while(continueRegistration);

        System.out.println("------------ENTER COURSE DETAILS-------------");
        System.out.println("Enter the student ID");
        String studentId = sc.nextLine();
        System.out.println("Enter the course ID");
        String courseId = sc.nextLine();

        courseEnrollment.enrollStudents(studentId, courseId);

        System.out.println("------------ENTER COURSE GRADING DETAILS-------------");
        System.out.println("Enter the student ID");
        studentId = sc.nextLine();
        System.out.println("Enter the course ID");
        courseId = sc.nextLine();
        System.out.println("Enter the grade");
        double grade = sc.nextDouble();

        Map<String, Double> grades = new HashMap<>();
        grades.put(courseId, grade);

        double finalGrade = gradeCalculator.gradeCalculation(studentId, grades);

        System.out.println("FINAL GRADE FOR THE "+studentId +": "+finalGrade);


    }catch(InvalidInputException | DuplicateRegistration | InvalidCourseException | MissingGradeException | EnrollmentFailuresException e){
        System.out.println("ERROR"+ e.getMessage());

    }
    sc.close();
}
}