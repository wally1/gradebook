package gradebook.model;

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

    public GradebookItem(String name, GradebookCategory gradebookCategory,
             int score) {
        this.name = name;
        this.gradebookCategory = gradebookCategory;
        this.score = (double) score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setScore(double score) {
        this.score = score;
    }
}
