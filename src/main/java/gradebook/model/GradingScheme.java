package main.java.gradebook.model;

import java.util.ArrayList;

/**
 * Interface for different kinds of Grading systems to implement
 * @author Eric
 *
 */

public interface GradingScheme {

 double A = 90;
 double B = 80;
 double C = 70;
 double D = 60;

 void loadGrades(ArrayList<GradebookItem> grades);

 double calculateAverage();

 String getLetterGrade();
}
