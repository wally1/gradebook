package gradebook.model;

import gradebook.model.GradebookCategory;

/**
 * Fill
 *
 */

public class GradebookItem {
    private String name;
    private GradebookCategory gradebookCategory;
    private double score;

    public GradebookItem(String name, GradebookCategory gradebookCategory,
             double score) {
        this.name = name;
        this.gradebookCategory = gradebookCategory;
        this.score = score;
    }

    public GradebookItem(String gName, GradebookCategory aGradebookCategory, //edit this too
             int aScore) {
        name = gName;
        gradebookCategory = aGradebookCategory;
        score = (double) aScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String gName) {
        name = gName;
    }

    public GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    public void setGradebookCategory(GradebookCategory gradebookCategory) {
        this.gradebookCategory = gradebookCategory;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double aScore) {
        score = aScore;
    }
}
