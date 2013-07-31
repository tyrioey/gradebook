package main.java.gradebook.model;

import java.util.*;

public class Course {
	private String name;
	private int courseNumber;
	private String subject;
	private ArrayList<Course> prereqs;	
	private ArrayList<Class> classes;
	private double average;
	
	public Course(String cname, int cnumber, String csubject, ArrayList<Course> cprereqs) {
		name = cname;
		courseNumber = cnumber;
		subject = csubject;
		prereqs = cprereqs;
		classes = new ArrayList<Class>();
		average = 0;
	}
	
	//across classes
	public double calculateAverage(GradingScheme scheme) {
	 average = 0;
	 for(int a = 0; a < classes.size(); a++) {
	  average+=classes.get(a).calculateAverage(scheme);
	 }
	 average /= classes.size();
	 return average;
	}
	
	
	public void addClass(Class a) {
	 classes.add(a);
	}
	public ArrayList<Class> getClasses() {
		return classes;
	}
	
	public String setName(String newName) {
	 name = newName;
 	 return name;
	}

	public int getCourseNumber(int cNumber) {
	 courseNumber = cNumber;
	 return courseNumber;
	}

	public String setSubject(String nSubject) {
	 subject = nSubject;
	 return subject;
	}

	public ArrayList<Course> setPrereqs(ArrayList<Course> nPre) {
	 prereqs = nPre;
	 return prereqs;
	}
	
	
	public String getName() {
		return name;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public String getSubject() {
		return subject;
	}

	public ArrayList<Course> getPrereqs() {
		return prereqs;
	}
}
