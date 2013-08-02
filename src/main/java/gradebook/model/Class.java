package gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Fill
 *
 */

public class Class extends Course {
    private String semester;
    private final Course course;
    private ArrayList<Section> sections = new ArrayList<Section>();
    private boolean scoreCalculated;
    private String letterGrade;
    private double avgScore;

    public Class(Course course, String semester) {
        super(course.getSubject(), course.getCourseID(),
            course.getCourseName(), course.getPrereqs());
        this.course = course;
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public double avgScore(GradingScheme gradingScheme) {
        double sum = 0;
        for (int i = 0; i < sections.size(); i++) {
            sum += sections.get(i).avgScore(gradingScheme);
        }
        avgScore = sum / sections.size();
        avgScore = Double.parseDouble(
            new DecimalFormat("#.00").format(avgScore));
        return avgScore;
    }

    public String letterGrade(GradingScheme gradingScheme) {
         if (scoreCalculated) {
             letterGrade = gradingScheme.getLetterGrade(avgScore);
         } else {
             avgScore = avgScore(gradingScheme);
             letterGrade = gradingScheme.getLetterGrade(avgScore);
         }
         return letterGrade;
    }
}
