package gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import gradebook.model.GradingSystem;

/**
 * Testing grades.
 *
 *
 */

@RunWith(JUnit4.class)
public class GradingSystemTest {
    Student student = new Student("Bob Hunt");
    GradebookCategory exam = new GradebookCategory("Tests", .40);
    GradebookCategory quiz = new GradebookCategory("Quizzes", .30);
    GradebookCategory hw = new GradebookCategory("hw", .30);
    GradebookItem exam1 = new GradebookItem("Exam 1", exam, 79.97);
    GradebookItem exam2 = new GradebookItem("Exam 2", exam, 92.32);
    GradebookItem quiz1 = new GradebookItem("Quiz", quiz, 91.2);
    GradebookItem finalExam = new GradebookItem("Final Exam", hw, 81.01);
    GradingSystem grader = new GradingSystem();
    ArrayList<GradebookItem> grades = new ArrayList<GradebookItem>();

    @Test
    public void testCreate() {
         assertNotNull("Grading failed", grader);
    }

    @Test
    public void testScoreCalculation() {
         grades.add(exam1);
         grades.add(exam2);
         grades.add(quiz1);
         grades.add(finalExam);
         grader.addGrades(grades);
         double score = grader.calculateScore();
         assertEquals(86.12, score, 0.00);
    }
}