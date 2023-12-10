package com.student;

import java.util.Map;

public class GradeCalculator {

    public double gradeCalculation(String studentId, Map<String,Double> courseGrades) throws InvalidInputException, MissingGradeException{
        if(!validInput(courseGrades)){
            throw new InvalidInputException("Invalid input of the course grade");
        }

        if(courseGrades.values().contains(null)){
            throw new MissingGradeException("Course grade missing from the report");
        }


        //finalizing the grade from the map 
        double sum = courseGrades.values().stream().mapToDouble(Double::doubleValue).sum();
        return sum/courseGrades.size();
    }

    public boolean validInput(Map<String, Double> courseGrades){
        return courseGrades != null && !courseGrades.isEmpty();
    }


    //custom exception classes
    public class InvalidInputException extends Exception{
        public InvalidInputException(String message){
            super(message);
        }
    }

    public class MissingGradeException extends Exception{
        public MissingGradeException(String message){
            super(message);
        }
    }
    
}
