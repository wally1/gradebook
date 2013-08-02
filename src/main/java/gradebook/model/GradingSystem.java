package gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * Fill
 * 
 */

public class GradingSystem implements GradingScheme {

    private ArrayList<GradebookItem> grades;
    private double finalScore;
    private String letterGrade;

    public void addGrades(ArrayList<GradebookItem> gGrades) {
        grades = gGrades;
    }

    public double calculateScore() {
        ArrayList<GradebookCategory> categoriesCalculated =
            new ArrayList<GradebookCategory>();
        double score = 0;
        double categoryScore;
        double categoryWeight;
        GradebookCategory currentCategory;
        
        for(GradebookItem currentItem : grades)
        {
            currentCategory = currentItem.getGradebookCategory();
            if (!categoriesCalculated.contains(currentCategory)) 
            {
                categoryScore = getCategoryAverage(currentCategory);
                categoryWeight = currentCategory.getPercentWeight();
                score += (categoryScore * categoryWeight);
                categoriesCalculated.add(currentCategory);
            }
        }
        
        finalScore =
            Double.parseDouble(new DecimalFormat("#.##").format(score));
        return finalScore;
    }

    public String getLetterGrade(double score) {
        if (score >= GradingScheme.A) {
             letterGrade = "A";
        } else if (score >= GradingScheme.B) {
            letterGrade = "B";
        } else if (score >= GradingScheme.C) {
            letterGrade = "C";
        } else if (score >= GradingScheme.D) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    public double getCategoryAverage(GradebookCategory category) {
        GradebookCategory currentCategory = category;
        double runningTotal = 0;
        double counter = 0;

        for(GradebookItem currentItem : grades)
        {
            if (currentItem.getGradebookCategory() == currentCategory) {
                runningTotal += currentItem.getScore();
                counter++;
            }	
        }
        
        return runningTotal / counter;
    }
}
