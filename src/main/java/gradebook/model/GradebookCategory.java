package main.java.gradebook.model;

public class GradebookCategory {
	
	private String name;
	private double weight;
	
	public GradebookCategory(String aName, double aWeight) {
	 name = aName;
	 weight = aWeight;
	}
	
	public double setWeight(double newWeight) {
	 weight = newWeight;
	 return weight;
	}
	public double getWeight() {
	 return weight;
	}
	
	public String setName(String newName) {
	 name = newName;
	 return name;
	}
	
	public String getName() {
	 return name;
	}

}
