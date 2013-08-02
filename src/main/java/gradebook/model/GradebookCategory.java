package gradebook.model;

/**
 * Fill
 *
 */

public class GradebookCategory {
    private String name;
    private double percentWeight;

    public GradebookCategory(String gName, double aPercentWeight) {
        name = gName;
        percentWeight = aPercentWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String gName) {
        name = gName;
    }

    public double getPercentWeight() {
        return percentWeight;
    }

    public void setPercentWeight(double aPercentWeight) {
        percentWeight = aPercentWeight;
    }
}
