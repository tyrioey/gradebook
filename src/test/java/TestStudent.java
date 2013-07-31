package test.java;

import static org.junit.Assert.*;

import main.java.gradebook.model.*;
import main.java.gradebook.model.Class;

import org.junit.Before;
import org.junit.Test;

public class TestStudent {

	private Student kid;
	private Student kid2;
	private GradebookItem hw;
	private GradebookItem hw2;
	private GradebookItem hw3;
	private Class CS;
	private Section a;
	
	@Before
	public void setUp() throws Exception {
	 kid = new Student("Jake");
	 kid2 = new Student("Ashley");
	 
	 CS = new Class("Summer");
	 a = new Section("Section A", CS);
		
	 GradebookCategory homework = new GradebookCategory("Homework",.25);
	 hw = new GradebookItem("HW 1", 100, homework);
	 hw2 = new GradebookItem("HW 2", 90, homework);
	 hw3 = new GradebookItem("HW 3", 80, homework);
	
	}

	@Test
	public void testInstantiation() {
	 assertNotNull("Jake wasn't created", kid);
	 assertNotNull("Ash wasn't created",kid2);
	}
	
	@Test
	public void testGet() {
	 String name = "Ashley";
	 assertTrue("Names aren't equal!",name.equals(kid2.getName()));
	 kid.setSection(a);
	 assertNotNull("Add section not working!", kid.getSection());
	 
	}
	
	//calculate grades and average testing done in TestGradingScheme
	@Test 
	public void testAddGrades() { 

	 kid.addGrade(hw);
 	 kid.addGrade(hw2);
	 kid.addGrade(hw3);

	 assertNotNull("Adding grades not working!", kid.getGrades());
	 assertTrue("Getting grades not working!", kid.getGrades().size() == 3);
	}
}	
