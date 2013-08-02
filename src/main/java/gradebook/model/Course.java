package gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Fill this
 *
 */

public class Course {
    private String subject;
    private int courseID;
    private String courseName;
    private ArrayList<Course> prereqs;
    private ArrayList<Class> classes = new ArrayList<Class>();
    private boolean score = false;
    private String letterGrade;
    private double avgScore;
    

    public Course(String subject, int courseID, String courseName) {
        this.subject = subject;
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public Course(String subject, int courseID, String courseName,
            ArrayList<Course> prereqs) {
        this.subject = subject;
        this.courseID = courseID;
        this.courseName = courseName;
        this.prereqs = prereqs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(ArrayList<Course> prereqs) {
        this.prereqs = prereqs;
    }

    public void addClass(Class newClass) {
        classes.add(newClass);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public double avgScore(GradingScheme gradingScheme) {
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            sum += classes.get(i).avgScore(gradingScheme);
        }
        avgScore = sum / classes.size();
        avgScore = Double.parseDouble(new DecimalFormat("#.00").format(avgScore));
        score = true;
        return avgScore;
    }

    public String letterGrade(GradingScheme gradingScheme) {
         if (score) {
             letterGrade = gradingScheme.getLetterGrade(avgScore);
         } else {
             avgScore = avgScore(gradingScheme);
             letterGrade = gradingScheme.getLetterGrade(avgScore);
         }
         return letterGrade;
    }
}
