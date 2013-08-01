package main.java.gradebook.model;

import java.util.ArrayList;

/**Classes is a Course offered during a semester. It has sections of
students. **/

public class Class {

 private ArrayList<Section> sections;
 private double average;
 private String semester;

 public Class(String name) {
  semester = name;
  sections = new ArrayList<Section>();
  average = 0;
 }

 public String getSemester() {
  return semester;
 }

 public String setSemester(String news) {
  semester = news;
  return semester;
 }

 public double calculateAverage(GradingScheme scheme) {
  average = 0;
  for (int a = 0; a < sections.size(); a++) {
  average += sections.get(a).calculateAverage(scheme);
  }
  average /= sections.size();
  return average;
 }

 public String getName() {
  return semester;
 }

 public ArrayList<Section> addSection(Section toAdd) {
  sections.add(toAdd);
  return sections;
 }

 public ArrayList<Section> removeSection(String name) {
  return null;
 }

 public ArrayList<Section> getSections() {
  return sections;
 }
}
