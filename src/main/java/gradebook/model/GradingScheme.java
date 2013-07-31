package main.java.gradebook.model;

import java.util.ArrayList;
import main.java.gradebook.model.GradebookItem;

public interface GradingScheme {
	
	double A = 90;
	double B = 80;
	double C = 70;
	double D = 60;
	
	void loadGrades(ArrayList<GradebookItem> grades);
	
	double calculateAverage();
	
	String getLetterGrade();
	
	

}
