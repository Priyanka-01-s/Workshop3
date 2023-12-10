import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.beans.Transient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.student.StudentRegistration;
import com.student.StudentRegistration.DuplicateRegistration;
import com.student.StudentRegistration.InvalidInputException;

public class StudentRegistrationTest {
    private static StudentRegistration studentRegistration;

    @BeforeAll
    public static void setUp(){
        studentRegistration = new StudentRegistration();

    }
    @Test 
    public void testStudentRegistration() throws InvalidInputException, DuplicateRegistration{
        studentRegistration.registedStudent("Priyanka","S01","psg@gmail.com","1234567890");
        assertTrue(studentRegistration.getRegisteredStudent().contains("S01"));
    }  
    
    // @Test 
    // public void testStudentRegistration1() throws InvalidInputException, DuplicateRegistration{
    //     studentRegistration.registedStudent("Priyanka","S01","psg@g?mail.com","4567890");
    //     assertTrue(studentRegistration.getRegisteredStudent().contains("S01"));
    // }  

    //invalid name registration
    @Test
        public void testInvalidName() throws InvalidInputException, DuplicateRegistration{
            studentRegistration.registedStudent("123", "1nm", "psg@hello.com", "1234567890");

        }

    //testing duplicate
    @Test
    public void testDuplicate() throws InvalidInputException, DuplicateRegistration{
        studentRegistration.registedStudent("Priyanka","S01","psg@gmail.com","1234567890");
        studentRegistration.registedStudent("Priyanka","S01","psg@gmail.com","1234567890");
    }
    
    
}
