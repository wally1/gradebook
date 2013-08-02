package gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Fill
 * 
 * 
 */

public class Section extends Class {
	
    private String id;
    private Class superClass;
    private double avgScore;
    private ArrayList<Student> students = new ArrayList<Student>();


    public Section(String id, Class superClass) {
        super(superClass.getCourse(), superClass.getSemester());
        this.id = id;
        this.superClass = superClass;
    }
    
    public double avgScore(GradingScheme gradingScheme) {
        double sum = 0;
        for(Student student : students)
        {
        	sum+=student.calculateScore(gradingScheme);
        }
        avgScore = sum / students.size();
        return Double.parseDouble(new DecimalFormat("#.00").format(avgScore));
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public Class getSuper() {
        return superClass;
    }

    public void setSuper(Class superClass) {
        this.superClass = superClass;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

}
