package main.java.gradebook.model;

import java.util.TreeMap;
import java.util.ArrayList;

/**
 * Regular grading system, no drops, etc.
 * @author Eric
 *
 */

public class RegularGrading implements GradingScheme {

	private TreeMap<String, ArrayList<GradebookItem>> grades;
	private double average;

	public void loadGrades(ArrayList<GradebookItem> aGrades) {
	 grades = new TreeMap<String, ArrayList<GradebookItem>>();

	 for (GradebookItem a: aGrades) {
	  if (grades.containsKey(a.getGradebookCategory().getName())) {
	   GradebookCategory cat = a.getGradebookCategory();
	   ArrayList<GradebookItem> newGrade = grades.get(cat.getName());
	   newGrade.add(a);
	   grades.put(a.getGradebookCategory().getName(), newGrade);
	  } else {
		  ArrayList<GradebookItem> add = new ArrayList<GradebookItem>();
		  add.add(a);
		  grades.put(a.getGradebookCategory().getName(), add);
	  }
	 }
	}
	public double calculateAverage() {

	 average = 0;
	 double weightedaverage = 0;
	 int count = 0;
	 double weight = 0;

	 for (String category: grades.keySet()) {
	  for (GradebookItem a: grades.get(category)) {
		  weightedaverage += a.getScore();
		  weight = a.getGradebookCategory().getWeight();
		  count++;
	  }
	  average += weightedaverage / count * weight;
	  weightedaverage = 0;
	  count = 0;
	 }
	 System.out.println(average);
	 return average;
	}

	public String getLetterGrade() {
	 if (average >= A) {
	  return "A";
	 } else if (average >= B) {
	  return "B";
	 } else if (average >= C) {
	  return "C";
	 } else if (average >= D) {
	  return "D";
	 } else {
	  return "F";
	 }
	}
}
