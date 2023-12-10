package com.student;

import java.util.HashSet;
//import java.util.Matcher;

public class StudentRegistration {
    private String name;
    private String Id;
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public String email() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    private HashSet<String> registedStudents = new HashSet<>();

    public void registedStudent(String name, String Id, String email, String phone)
            throws InvalidInputException, DuplicateRegistration {
        if (!validStudent(name, Id, email, phone)) {
            throw new InvalidInputException("Invalid format of input");

        }

        if (registedStudents.contains(Id)) {
            throw new DuplicateRegistration("Duplicate student found!!");
        }

        registedStudents.add(Id);
        System.out.println("Student added successfully");
    }
    public HashSet<String> getRegisteredStudent(){
        return registedStudents;
    }

    public boolean validStudent(String name, String Id, String email, String phone) {
        return validName(name) && validId(Id) && validEmail(email) && validPhone(phone);

    }

    // regex expressions
    public boolean validName(String name) {
        String regex = "^[A-Z][a-zA-Z]+$";
        System.out.println(name.matches(regex));
        return name.matches(regex);
    }

    public boolean validId(String Id) {
        String regex = "^[a-zA-Z0-9]+$";
        System.out.println(Id.matches(regex));
        return Id!= null && Id.matches(regex);
    }

    public boolean validEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        System.out.println(email.matches(regex));
        return email.matches(regex);
    }

    public boolean validPhone(String phone) {
        String regex = "^[0-9]{10}$";
        System.out.println(phone.matches(regex));
        return phone.matches(regex);
    }


    //custom exception
    public class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);

        }

    }

    public class DuplicateRegistration extends Exception {
        public DuplicateRegistration(String message) {
            super(message);
        }

    }

}
