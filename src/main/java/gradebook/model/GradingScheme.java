package gradebook.model;

import java.util.ArrayList;

/**
 * Fill
 * 
 */

public interface GradingScheme {
	
    double A = 90.0;
    double B = 80.0;
    double C = 70.0;
    double D = 60.0;

    void addGrades(ArrayList<GradebookItem> grades);
    double calculateScore();
   // String reportAverages(); //remove?
    //String reportScores();
    //String reportLetterGrades();
    String getLetterGrade(double score);
    
    //remove abstract methods
}
