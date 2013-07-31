package main.java.gradebook.model;

import java.util.*;

public class Student {
	private String name;
	private ArrayList<GradebookItem> grades;
	private Section section;
	
	public Student(String cname) {
	 name = cname;
	 grades = new ArrayList<GradebookItem>();
	 section = null;
	}

	public double calculateAverage(GradingScheme scheme) {
	 scheme.loadGrades(grades);
	 double average = scheme.calculateAverage();
	 return average;
	}

	public String setName(String newName) {
	 name = newName;
	 return name;
	}
	public String getName() {
	 return name;
	}
	
	public Section setSection(Section newSection) {
	 section = newSection;
	 return section;
	}
	public Section getSection() {
	 return section;
	}
	
	public GradebookItem addGrade(GradebookItem aGrade) {
	 grades.add(aGrade);
	 return aGrade;
	}
	
	public ArrayList<GradebookItem> getGrades() {
	 return grades;
	}
		
}
