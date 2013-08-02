package gradebook.model;

/**
 * Fill
 *
 */

public class GradebookCategory {
    private String name;
    private double percentWeight;

    public GradebookCategory(String name, double percentWeight) {
        this.name = name;
        this.percentWeight = percentWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public double getPercentWeight() {
        return percentWeight;
    }

    public void setPercentWeight(double percentWeight) {
        this.percentWeight = percentWeight;
    }
}
