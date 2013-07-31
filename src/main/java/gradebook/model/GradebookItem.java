package main.java.gradebook.model;

/**
 * Grades ie. Homework 1, Homework 2, etc, each references the
 * Category it belongs to
 * @author Eric
 *
 */

public class GradebookItem implements Comparable<GradebookItem> {

	private String name;
	private double score;
	private GradebookCategory category;

	public GradebookItem(String aName, double aSc, GradebookCategory aCat) {
		name = aName;
		category = aCat;
		score = aSc;
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

	public GradebookCategory setGradebookCategory(GradebookCategory nCat) {
		category = nCat;
		return category;
	}

	public GradebookCategory getGradebookCategory() {
		return category;
	}

	public int compareTo(GradebookItem other) {
	 if (score < other.getScore()) {
	  return -1;
	 } else if (score > other.getScore()) {
	  return 1;
	 }
	 return 0;
	}

	public String toString() {
	 return score + "-" + category.getName() + "-" + category.getWeight();
	}
}
