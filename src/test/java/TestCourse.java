package test.java;

import static org.junit.Assert.*;

import main.java.gradebook.model.*;
import main.java.gradebook.model.Class;


import org.junit.Before;
import org.junit.Test;

public class TestCourse {

	Course CS2340;
	GradingScheme regular;
	GradingScheme replace;
	GradingScheme drop;
	
	GradebookCategory quiz;
	GradebookCategory homework; 
	GradebookCategory test;
	
	Student eric;
	Student muersa;
	Student mina;

	Class CS;
	Class CS2;
	Section sectionA;
	Section sectionB;
	
	@Before
	public void setUp() throws Exception {
	regular = new RegularGrading();
	replace = new ReplaceLowestGrade();
	drop = new DropLowestGrades();
	
	homework = new GradebookCategory("Homework", 1);
	
	eric = new Student("Eric");
	muersa = new Student("Muersa");
	mina = new Student("Mina");
	
	
	eric.addGrade(new GradebookItem("HW 1", 100, homework));
	eric.addGrade(new GradebookItem("HW 2", 90, homework));
	eric.addGrade(new GradebookItem("HW 3", 80, homework));
	
	muersa.addGrade(new GradebookItem("HW 1", 100, homework));
	muersa.addGrade(new GradebookItem("HW 2", 100, homework));
	muersa.addGrade(new GradebookItem("HW 3", 110, homework));
	
	mina.addGrade(new GradebookItem("HW 1", 100, homework));
	mina.addGrade(new GradebookItem("HW 2", 90, homework));
	mina.addGrade(new GradebookItem("HW 3", 100, homework));
	
	CS2340 = new Course("Objects and Design", 2340,"CS", null);
	CS = new Class("Summer of Dragon Flame");
	CS2 = new Class("Winter of Lost Moon");
	CS2340.addClass(CS);
	CS2340.addClass(CS2);
	
	sectionA = new Section("Section A",CS);
	sectionB = new Section("Section B",CS2);

	}
	@Test
	public void testGetters() {
		assertTrue("Name",CS2340.getName().equals("Objects and Design"));
		assertTrue("Subject",CS2340.getSubject().equals("CS"));
		assertTrue("Number",CS2340.getCourseNumber() == 2340);
	}
	
	@Test
	public void testCourseAverage() {

		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionB.addStudent(muersa);
		double average = (((100+90+80)/3.0 + (100+90+100)/3.0)/2 + (100+100+110)/3.0)/2; //98.333333
		
		assertEquals(average, CS2340.calculateAverage(regular),.2);
		
	}
	@Test
	public void testCourseAverage2() {

		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionB.addStudent(muersa);
		double average = (((100+90)/2.0 + (100+100)/2.0)/2 + (110+100)/2.0)/2; //101.25
		
		assertEquals(average, CS2340.calculateAverage(drop),.02);
		
	}

}
