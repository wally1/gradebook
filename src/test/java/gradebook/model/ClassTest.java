package gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Testing Class
 *
 *
 */

@RunWith(JUnit4.class)
public class ClassTest {
    Course course = new Course("HIST", 1101, "World History");
    Class class1 = new Class(course, "Summer 2013");
    Course course1 = new Class(course, "Summer 2013");
    Section section = new Section("A", class1);
    Section section2 = new Section("B", class1);
    GradebookCategory gradebookCategory = new GradebookCategory("Exams", 1);
    
    Student newStudent1 = new Student("Bob Hunt");
    Student newStudent2 = new Student("Raymond Johnson");
    Student newStudent3 = new Student("Mary Mitchell");
    


    @Test
    public void testClass() {
        assertNotNull("Class failed", class1);
        assertNotNull("Class failed", class1);
    }

    @Test
    public void testSetUp() {
        String subject = class1.getSubject();
        int courseID = class1.getCourseID();
        String courseName = class1.getCourseName();
        String semester = class1.getSemester();
        assertEquals("getSubject() failed.", "HIST", subject);
        assertEquals("getCourseNumber() failed.", 1101, courseID);
        assertEquals("getCourseID() failed.", "World History",
            courseName);
        assertEquals("getSemester() failed.", "Summer 2013", semester);
    }

    @Test
    public void testOtherSetUp() {
       class1.addSection(section);
       ArrayList<Section> sections = class1.getSections();
       assertTrue("Section failed.", sections.contains(section));
    }

    @Test
    public void testAverages() {
        newStudent1.addGradebookItem(new GradebookItem("Exam 1",
             gradebookCategory, 50));
        newStudent1.addGradebookItem(new GradebookItem("Exam 2",
             gradebookCategory, 75));
        newStudent2.addGradebookItem(new GradebookItem("Exam 1",
             gradebookCategory, 57));
        newStudent2.addGradebookItem(new GradebookItem("Exam 2",
             gradebookCategory, 100));
        newStudent3.addGradebookItem(new GradebookItem("Exam 1",
             gradebookCategory, 92));
        newStudent3.addGradebookItem(new GradebookItem("Exam 2",
             gradebookCategory, 43));
        section.addStudent(newStudent1);
        section.addStudent(newStudent2);
        section2.addStudent(newStudent3);
 
        class1.addSection(section);
        class1.addSection(section2);
        
        assertEquals(2, class1.getSections().size());
        GradingScheme grader = new GradingSystem();
        double avgScore = class1.avgScore(grader);
        assertEquals(69.0, avgScore, 0.00);
        String letterGrade = class1.letterGrade(grader);
        assertEquals("LetterGrade failed.","D", letterGrade);

    }
}