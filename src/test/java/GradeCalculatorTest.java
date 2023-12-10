import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.student.GradeCalculator;
import com.student.GradeCalculator.InvalidInputException;
import com.student.GradeCalculator.MissingGradeException;

public class GradeCalculatorTest{

    private final String studentId;
    private Map<String , Double> courseGrade;
    private final double expectedGrade;
    
    public GradeCalculatorTest(String studentId, Map<String , Double> courseGrade,double expectedGrade){
        this.studentId = studentId;
        this.courseGrade = courseGrade;
        this.expectedGrade = expectedGrade;
    }

  
    Collection<Object[]> testGradeCalculator(){
        return Arrays.asList(new Object[][] {
            {"123ab", createGrades(90.0)},
            {"S01", createGrades(80.0)},
            
        });
    }
    

    @ParameterizedTest
    @MethodSource 
        public void testGradeCalculator() throws InvalidInputException, MissingGradeException{
            GradeCalculator gradeCalculator = new GradeCalculator();
            double calculatorGrade = gradeCalculator.gradeCalculation(studentId, courseGrade);
            assertEquals(expectedGrade, calculatorGrade);
        }
    

    private static Map<String, Double> createGrades(Double grades){
        Map<String, Double> courseGrade = new HashMap<>();
        courseGrade.put("Math", grades);
        return courseGrade;
    }
}



    @ParameterizedTest
    @MethodSource 