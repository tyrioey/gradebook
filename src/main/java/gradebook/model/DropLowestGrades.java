package main.java.gradebook.model;

import java.util.TreeMap;
import java.util.ArrayList;

/**
 * Drops the lowest weighted grade from a Student's grades
 * This means that a homework grade of 80 weighted at 20% (16 overall)
 * will be dropped instead of dropping a test grade of 50 weighted at 60%
 * (30 overall).
 * @author Eric
 *
 */

public class DropLowestGrades implements GradingScheme {

	private TreeMap<String, ArrayList<GradebookItem>> grades;
	private double average;

	public void loadGrades(ArrayList<GradebookItem> aGrades) {
	 grades = new TreeMap<String, ArrayList<GradebookItem>>();

	 for (GradebookItem a: aGrades) {
	  if (grades.containsKey(a.getGradebookCategory().getName())) {
	   String name = a.getGradebookCategory().getName();
	   ArrayList<GradebookItem> newGrade = grades.get(name);
	   newGrade.add(a);
	   grades.put(a.getGradebookCategory().getName(), newGrade);
	  } else {
	   ArrayList<GradebookItem> newGrade = new ArrayList<GradebookItem>();
	   newGrade.add(a);
	   grades.put(a.getGradebookCategory().getName(), newGrade);
	  }
	 }
	}

	//drops lowest weighted grade
	public void dropLowestGrade() {
	 double lowest = 101;
	 String categoryToRemoveFrom = "error";
	 int index = 0;

	 for (String category: grades.keySet()) {
	  ArrayList<GradebookItem> cateGrades = grades.get(category);
	  for (int a = 0; a < cateGrades.size(); a++) {
	   GradebookItem currGrade = cateGrades.get(a);
	   GradebookCategory cate = currGrade.getGradebookCategory();

	   if (currGrade.getScore() * cate.getWeight() < lowest) {
	    lowest = currGrade.getScore() * cate.getWeight();
		categoryToRemoveFrom = cate.getName();
		index = a;
	   }
	  }
	 }
	 grades.get(categoryToRemoveFrom).remove(index);
	}

	public double calculateAverage() {
	 dropLowestGrade();
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
