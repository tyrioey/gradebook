package main.java.gradebook.model;

import java.util.*;

public class ReplaceLowestGrade implements GradingScheme {
	
	private TreeMap<String, ArrayList<GradebookItem>> grades;
	private double average;

	public void loadGrades(ArrayList<GradebookItem> aGrades) {
		 grades = new TreeMap<String, ArrayList<GradebookItem>>();
		 
		 for(GradebookItem a: aGrades) {
		  if(grades.containsKey(a.getGradebookCategory().getName())) {
		   ArrayList<GradebookItem> newGrade = grades.get(a.getGradebookCategory().getName());
		   newGrade.add(a);
		   grades.put(a.getGradebookCategory().getName(), newGrade);
		  }
		  else {
			  ArrayList<GradebookItem> newGrade = new ArrayList<GradebookItem>();
			  newGrade.add(a);
			  grades.put(a.getGradebookCategory().getName(), newGrade);
		  }
		 }
		}
	//drops lowest weighted grade
	public void replaceLowestGrade() {


		 double lowest = 10000;
		 double secondLowest = 10000;
		 GradebookCategory categoryToRemoveFrom = null;
		 int index = 0;
		 
		 for(String category: grades.keySet()) {
			 ArrayList<GradebookItem> cateGrades = grades.get(category);
			  for(int a = 0; a< cateGrades.size(); a++) {
				  GradebookItem currGrade = cateGrades.get(a);
				  if(currGrade.getScore()*currGrade.getGradebookCategory().getWeight() < lowest) {
					  secondLowest = lowest/currGrade.getGradebookCategory().getWeight();
					  lowest = currGrade.getScore()*currGrade.getGradebookCategory().getWeight();
					  categoryToRemoveFrom = currGrade.getGradebookCategory();
					  index = a;
				  }
			  }
		 }
		 grades.get(categoryToRemoveFrom.getName()).remove(index);
		 grades.get(categoryToRemoveFrom.getName()).add(new GradebookItem("Replacement",secondLowest,categoryToRemoveFrom));
		
	}
	

		
		public double calculateAverage() {
		
		 replaceLowestGrade();
		 average = 0;
		 double weightedaverage = 0;
		 int count = 0;
		 double weight = 0;
		 
		 for(String category: grades.keySet()) {
		  for(GradebookItem a: grades.get(category)) {
			  weightedaverage += a.getScore();
			  weight = a.getGradebookCategory().getWeight();
			  count++;
		  }
		  average +=weightedaverage/count*weight;
		  weightedaverage = 0;
		  count = 0;
		 }
		 System.out.println(average);
		 return average;
		 
		}
	public String getLetterGrade() {
	 if(average >= A)
	  return "A";
	 else if(average >= B)
	  return "B";
	 else if(average >= C)
	  return "C";	 
	 else if(average >= D)
	  return "D";	 
	 else
	  return "F";
	}
	
}
