package test.java;

import static org.junit.Assert.*;

import main.java.gradebook.model.*;
import main.java.gradebook.model.Class;


import org.junit.Before;
import org.junit.Test;

public class TestClass {

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
	
	CS = new Class("Summer");
	sectionA = new Section("Section A",CS);
	sectionB = new Section("Section B",CS);
	CS.addSection(sectionA);
	CS.addSection(sectionB);
	
	}
	@Test
	public void testGetters() {
		Section sectionC = new Section("Test",CS);
		CS.addSection(sectionC);
		assertTrue(CS.getSections().size() == 3);
		assertTrue(CS.getName().equals("Summer"));
	}
	
	@Test
	public void testClassAverage() {
		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionB.addStudent(muersa);
		double average = (((100+90+80)/3.0 + (100+90+100)/3.0)/2.0 + (100+100+110)/3.0)/2.0; //98.333333
		
		assertEquals(average, CS.calculateAverage(regular),.01);
		
	}
	@Test
	public void testClassAverageDrop() {
		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionB.addStudent(muersa);
		double average = (((100+90)/2.0 + (100+100)/2.0)/2 + (110+100)/2.0)/2; //101.25
		
		assertEquals(average, CS.calculateAverage(drop),.01);
	}
	
	@Test
	public void testClassAverageReplace() {
		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionB.addStudent(muersa);
		double average = (((100+90+90)/3.0 + (100+100+100)/3.0)/2 + (110+100+110)/3.0)/2; //102.5
		
		assertEquals(average, CS.calculateAverage(replace),.01);
	}
	
	public void testSectionAverageReplace2() {
		sectionA.addStudent(eric);
		sectionA.addStudent(mina);
		sectionA.addStudent(muersa);
		GradebookCategory quiz = new GradebookCategory("Quiz",.6);
		homework.setWeight(.4);
		eric.addGrade(new GradebookItem("Quiz 1",100,quiz));
		mina.addGrade(new GradebookItem("Quiz 1",80,quiz));
		muersa.addGrade(new GradebookItem("Quiz 1",90,quiz));
		
		double average = (100+90+90)/3.0*.4+100*.6;
		average += (100+100+100)/3.0*.4+80*.6;
		average += (100+110+110)/3.0*.4+90*.6;
		average /= 3;
		
		assertEquals(average, CS.calculateAverage(replace),.01);
		
	}

}
