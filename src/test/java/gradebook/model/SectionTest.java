package gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import gradebook.model.Class;

/**
 * Testing Section
 *
 */

@RunWith(JUnit4.class)
public class SectionTest {
    Course course = new Course("HIST", 4057, "North America");
    Class superClass = new Class(course, "Summer 2013");
    Section section = new Section("A", superClass);
    Student newStudent1 = new Student("Bob Hunt");
    Student newStudent2 = new Student("Raymond Johnson");
    Student newStudent3 = new Student("Mary Mitchell");
    GradebookCategory gradebookCategory = new GradebookCategory("Exam", 1);

    @Test
    public void testCreate() {
        assertNotNull("Section failed", section);
    }

    @Test
    public void testStudentsSetup() {
        section.addStudent(newStudent1);
        ArrayList<Student> students = section.getStudents();
        assertTrue("Students setup failed.",
            students.contains(newStudent1));
    }

    @Test
    public void testAverages() {
        GradingScheme grader = new GradingSystem();
        newStudent1.addGradebookItem(new GradebookItem("Exam 1", 
            gradebookCategory, 50));
        newStudent1.addGradebookItem(new GradebookItem("Exam 2", 
            gradebookCategory, 51));
        section.addStudent(newStudent1);
        String letterGrade = section.letterGrade(grader);
        assertEquals("LetterGrade failed.","F", letterGrade);
        newStudent2.addGradebookItem(new GradebookItem("Test 1",
            gradebookCategory, 70));
        newStudent2.addGradebookItem(new GradebookItem("Test 2",
            gradebookCategory, 100));
        section.addStudent(newStudent2);
        newStudent3.addGradebookItem(new GradebookItem("Test 1",
            gradebookCategory, 80));
        newStudent3.addGradebookItem(new GradebookItem("Test 2",
            gradebookCategory, 95));
        section.addStudent(newStudent3);
        double averageScore = section.avgScore(grader);
        assertEquals(74.33, averageScore, 0.00);
    }
}