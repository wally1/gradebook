package gradebook.model;

import java.util.ArrayList;

/**
 * fill
 * 
 * 
 */
public class Student {
    private String name;
    private ArrayList<GradebookItem> gradebookItems = new ArrayList<GradebookItem>();
    private double score;
    private String letterGrade;
    private boolean scoreCalculated = false;

    public Student(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }

    public void addGradebookItem(GradebookItem gradebookItem) {
        gradebookItems.add(gradebookItem);
    }

    public double calculateScore(GradingScheme gradingScheme) {
         gradingScheme.addGrades(gradebookItems);
         score = gradingScheme.calculateScore();
         scoreCalculated = true;
         return score;
    }

    public String calculateLetterGrade(GradingScheme gradingScheme) {
         if (scoreCalculated) {
             letterGrade = gradingScheme.getLetterGrade(score);
         } else {
             score = calculateScore(gradingScheme);
             letterGrade = gradingScheme.getLetterGrade(score);
         }
         return letterGrade;
    }
}
