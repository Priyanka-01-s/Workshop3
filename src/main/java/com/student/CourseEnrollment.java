package com.student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CourseEnrollment {

    private static final int MAX=50;
    //will store student and the enrolled course
    private Map<String , HashSet<String>> enrollStudentsCourse = new HashMap<>();

    public void enrollStudents(String studentId, String courseId) throws InvalidCourseException, EnrollmentFailuresException{
        if(!validCourse(courseId)){
            throw new InvalidCourseException("Course is invalid");
        }

        if(isCourseFull(courseId)){
            throw new EnrollmentFailuresException("Course is full. Cannot enroll the student");
        }

        enrollStudentsCourse.computeIfAbsent(courseId, k->new HashSet<>()).add(studentId);
        System.out.println("Student Enrolled in the course");

    }

    public boolean validCourse(String courseId){
        return courseId != null && !courseId.trim().isEmpty();
    }

    public boolean isCourseFull(String courseId){
        HashSet<String> enrollStudents = enrollStudentsCourse.getOrDefault(courseId,new HashSet<>());
        return enrollStudents.size() >= MAX;
    }


    public class InvalidCourseException extends Exception{
        public InvalidCourseException(String message){
            super(message);
        }
    }

    public class EnrollmentFailuresException extends Exception{
        public EnrollmentFailuresException(String message){
            super(message);
        }
    }













    // private List<Course> course;

    // //emrollmwnt of diff course and store it in list
    // public CourseEnrollment(){
    //     this.course = new ArrayList<>();
    // }

    // public void enrollStudents(String studentId, String course_Id){
    //     Course course = findCourse(course_Id);
    //     if(course != null){
    //         course.enrollStudents(studentId,course_Id);
    //     }
    // }

    // //finding a course in te course list

    // public Course findCourse(String course_id){
    //     for(Course courses : course){
    //         if(courses.course_id.equals(course_id)){
    //             return courses;
    //         }
    //     }
    //     return null;
    // }


    // private class Course{
    //     String course_id;
    //     List<Student> students;

    //     public Course(String course_id){
    //         this.course_id = course_id;
    //         this.students = new ArrayList<>();

    //     }

    //     public void studentsEnrolled(String studentId){
    //         if(students.contains(studentId)){
    //             students.add(studentId);
    //         }

    //     }
    // }
}
