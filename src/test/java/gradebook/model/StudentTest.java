package gradebook.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Testing Student
 *
 */

@RunWith(JUnit4.class)
public class StudentTest {
    private Student student = new Student("Bob Hunt");
    private GradebookCategory gradebookCategory = 
        new GradebookCategory("Exam", 1);
    private GradebookItem gradebookItem = new GradebookItem("Exam1",
        gradebookCategory, 50);
    private GradebookItem gradebookItem2 = new GradebookItem("Exam2",
        gradebookCategory, 75);

    @Test
    public void testStudent() {
        assertNotNull("Student setup failed", student);
    }

    @Test
    public void testSetup() {
        assertEquals("Bob Hunt", student.getName());
    }

    @Test
    public void testGrades() {
        student.addGradebookItem(gradebookItem);
        assertNotNull("grades failed",
            student.getGradebookItems());
    }

    @Test
    public void testAverageCalculations() {
        student.addGradebookItem(gradebookItem);
        student.addGradebookItem(gradebookItem2);
        double studentScore = student.calculateScore(new GradingSystem());
        assertEquals(62.5, studentScore, 0.00);
    }
}