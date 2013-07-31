package main.java.gradebook.model;

import main.java.gradebook.model.GradebookCategory;

public class GradebookItem implements Comparable<GradebookItem> {
	
	private String name;
	private double score;
	private GradebookCategory category;
	
	public GradebookItem(String aName, double aScore, GradebookCategory aCategory) {
		name = aName;
		category = aCategory;
		score = aScore;
	}
	
	public String setName(String newName) {
		name = newName;
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public double setScore(double newScore) {
		score = newScore;
		return score;
	}	
	
	public double getScore() {
		return score;
	}
	
	public GradebookCategory setGradebookCategory(GradebookCategory newCat) {
		category = newCat;
		return category;
	}	
	
	public GradebookCategory getGradebookCategory() {
		return category;
	}

	public int compareTo(GradebookItem other) {
	 if(score < other.getScore())
	  return -1;
	 else if(score > other.getScore())
	  return 1;
	 return 0;
	}
	public String toString() {
	 return score +" - "+category.getName()+" - "+category.getWeight();
	}

}
