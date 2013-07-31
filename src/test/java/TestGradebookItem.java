package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.java.gradebook.model.*;

public class TestGradebookItem {

	GradebookItem hw;
	GradebookItem hw2;
	GradebookItem hw3;
	
	GradebookCategory cat1; 
	GradebookCategory cat2;
	
	@Before
	public void setUp() throws Exception {	
		
	 cat1 = new GradebookCategory("Homework",.5);
	 cat2 = new GradebookCategory("Asdf", .4);
	 hw = new GradebookItem("Homework 1", 82, cat1); 
	 hw2 = new GradebookItem("Homework 2", 84, cat2);
	 hw3 = new GradebookItem("Homework 3", 85, cat1); 
	}

	@Test
	public void testGradebookItems() {
	 assertNotNull("Null",hw);
	 assertNotNull("Null Category", hw.getGradebookCategory());
	 assertTrue("Grades wrong", 84 == hw2.getScore());
	 assertTrue("Weights wrong", 33.6 == hw2.getScore() * hw2.getGradebookCategory().getWeight());
 	 assertTrue(!hw.getGradebookCategory().getName().equals(hw2.getGradebookCategory().getName()));
	}

}
