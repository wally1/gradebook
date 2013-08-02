package gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import gradebook.model.Class;

/**
 * Testing Course
 *
 */

@RunWith(JUnit4.class)
public class CourseTest {
    ArrayList<Course> prereqs = new ArrayList<Course>();
    Course course = new Course("HIST", 4055, "Americas", prereqs);
    Class class1 = new Class(course, "Summer 2013");
    Class class2 = new Class(course, "Summer 2013");
    Section section1 = new Section("A", class1);
    Section section2 = new Section("B", class2);
    GradebookCategory gradebookCategory = new GradebookCategory("Exams", 1);
    
    Student newStudent1 = new Student("Bob Hunt");
    Student newStudent2 = new Student("Raymond Johnson");
    Student newStudent3 = new Student("Mary Mitchell");

    
    @Test
    public void testCourse() {
        assertNotNull("Course failed.", course);
        String subject = course.getSubject();
        int courseID = course.getCourseID();
        String courseName = course.getCourseName();
        ArrayList<Course> allPrereqs = course.getPrereqs();
        assertEquals("HIST", subject);
        assertEquals(4055, courseID);
        assertEquals("Americas", courseName);
        assertSame(prereqs, allPrereqs);
    }

    @Test
    public void testSetters() {
        course.setSubject("HIST");
        course.setCourseID(4056);
        course.setCourseName("South America");
        prereqs.add(new Course("HIST", 4056, "South America"));
        course.setPrereqs(prereqs);
        String subject = course.getSubject();
        int courseNumber = course.getCourseID();
        String courseName = course.getCourseName();
        ArrayList<Course> allPrereqs = course.getPrereqs();
        assertEquals("setSubject() failed.", "HIST", subject);
        assertEquals("setCourseID() failed.", 4056, courseNumber);
        assertEquals("setCouseName() failed.","South America", courseName);
        assertSame("setPrereqs() failed.", prereqs,allPrereqs);
    }

    @Test
    public void testAverages() {
        newStudent1.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 50));
        newStudent1.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 75));
        newStudent2.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 57));
        newStudent2.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 100));
        newStudent3.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 92));
        newStudent3.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 43));

        section1.addStudent(newStudent1);
        section1.addStudent(newStudent2);
        section2.addStudent(newStudent3);
        
        class1.addSection(section1);
        class2.addSection(section2);
        course.addClass(class1);
        course.addClass(class2);
        GradingScheme grader = new GradingSystem();
        String letterGrade = course.letterGrade(grader);
        assertEquals("LetterGrade failed.", "D", letterGrade);
        double averageScore = course.avgScore(grader);
        assertEquals(69, averageScore, 0.00);
    }
}