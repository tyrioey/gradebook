package main.java.gradebook.model;

import java.util.*;

public class Section {
	String name;
	ArrayList<Student> students;
	Class parentClass;
	
	public Section(String aName, Class aParentClass) {
	 name = aName;
		students = new ArrayList<Student>();
		parentClass = aParentClass;
		aParentClass.addSection(this);
	}
	
	public ArrayList<Student> addStudent(Student toAdd) {
		students.add(toAdd);
		return students;
	}
	
	public ArrayList<Student> removeStudent(String name) {
		int index = students.indexOf(name);
		students.remove(index);
		return students;
	}
	public ArrayList<Student> removeStudent(Student toRemove) {
		students = removeStudent(toRemove.getName());
		return students;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public double calculateAverage(GradingScheme scheme) {
		double sum = 0;
		for(Student kid: students) {
			sum += kid.calculateAverage(scheme);
		}
		sum /= students.size();
		return sum;
	}
	public Class getParentClass() {
		return parentClass;
	}
	public String setName(String newName) {
	 name = newName;
	 return name;
	}
	public String getName() {
	 return name;
	}

}
