package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.java.gradebook.model.*;


public class TestGradingScheme{
	
	GradingScheme regular;
	GradingScheme replace;
	GradingScheme drop;
	
	GradebookCategory quiz;
	GradebookCategory homework; 
	GradebookCategory test;
	
	Student eric;

	@Before
	public void setUp() throws Exception {
	regular = new RegularGrading();
	replace = new ReplaceLowestGrade();
	drop = new DropLowestGrades();
	
	quiz = new GradebookCategory("Quiz", .20);
	homework = new GradebookCategory("Homework", .20);
	test = new GradebookCategory("Test", .60);
	
	eric = new Student("Eric");
	
	eric.addGrade(new GradebookItem("HW 1", 100, homework));
	eric.addGrade(new GradebookItem("HW 2", 90, homework));
	eric.addGrade(new GradebookItem("HW 3", 80, homework));
	eric.addGrade(new GradebookItem("Quiz 1", 100, quiz));
	eric.addGrade(new GradebookItem("Quiz 2", 80, quiz));
	eric.addGrade(new GradebookItem("Test 1", 90, test));
	eric.addGrade(new GradebookItem("Test 2", 80, test));

	}

	@Test
	public void testRegularGrading() {
	 double average = .2*(100+90+80)/3.0 + .2*(100+80)/2 + .6*(90+80)/2.0; //87
	 assertEquals(average, eric.calculateAverage(regular),.01);
	}
	
	@Test
	public void testDropGrading() {
	 double average = .2*(100+90)/2.0 + .2*(100+80)/2 + .6*(90+80)/2.0; //88 after dropping 80 from homework
	 assertEquals(average, eric.calculateAverage(drop),.01);
	}
	@Test
	public void testDropGrading2() {
	 eric.addGrade(new GradebookItem("HW 4", 0, homework));
	 eric.addGrade(new GradebookItem("HW 5", 0, homework));
	 double average = .2*(100+90+80+0)/4.0 + .2*(100+80)/2 + .6*(90+80)/2.0; //82.5 after dropping 0 from homework
	 assertEquals(average, eric.calculateAverage(drop),.01);
	}
	
	@Test
	public void testReplaceGrading() {
	 double average = .2*(100+90+90)/3.0 + .2*(100+80)/2 + .6*(90+80)/2.0; //87.667 after replacing 80 with 90 from homework
	 assertEquals(average, eric.calculateAverage(replace),.01);
	}
	


}
