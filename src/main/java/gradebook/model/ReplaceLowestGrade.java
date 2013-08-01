package main.java.gradebook.model;

import java.util.TreeMap;
import java.util.ArrayList;

/**
 * replaces the lowest weighted grade with the 2nd lowest weighted
 * grade in the same category
 * @author Eric
 *
 */

public class ReplaceLowestGrade implements GradingScheme {

 private TreeMap<String, ArrayList<GradebookItem>> grades;
 private double average;

 public void loadGrades(ArrayList<GradebookItem> aGrades) {

 grades = new TreeMap<String, ArrayList<GradebookItem>>();

 for (GradebookItem a: aGrades) {
  if (grades.containsKey(a.getGradebookCategory().getName())) {
   GradebookCategory cate = a.getGradebookCategory();
   ArrayList<GradebookItem> nGrad = grades.get(cate.getName());
   nGrad.add(a);
   grades.put(a.getGradebookCategory().getName(), nGrad);
  } else {
     ArrayList<GradebookItem> nGrad;
     nGrad = new ArrayList<GradebookItem>();
     nGrad.add(a);
     grades.put(a.getGradebookCategory().getName(), nGrad);
   }
  }
}

 //drops lowest weighted grade
 public void replaceLowestGrade() {

  double lowest = Double.MAX_VALUE;
  double secondLowest = Double.MAX_VALUE;
  GradebookCategory cateRemove = null;
  int index = 0;

  for (String category: grades.keySet()) {
   ArrayList<GradebookItem> cateGrades = grades.get(category);
   for (int a = 0; a < cateGrades.size(); a++) {
    GradebookItem currGrade = cateGrades.get(a);
    GradebookCategory cate = currGrade.getGradebookCategory();
    if (currGrade.getScore() * cate.getWeight() < lowest) {
     secondLowest = lowest / cate.getWeight();
     lowest = currGrade.getScore() * cate.getWeight();
     cateRemove = cate;
     index = a;
    }
   }
  }
  grades.get(cateRemove.getName()).remove(index);
  GradebookItem add = new GradebookItem("Swap", secondLowest, cateRemove);
  grades.get(cateRemove.getName()).add(add);
 }

 public double calculateAverage() {

  replaceLowestGrade();
  average = 0;
  double weightedaverage = 0;
  int count = 0;
  double weight = 0;

  for (String category: grades.keySet()) {
   for (GradebookItem a: grades.get(category)) {
    weightedaverage += a.getScore();
    weight = a.getGradebookCategory().getWeight();
    count++;
   }
   average += weightedaverage / count * weight;
   weightedaverage = 0;
   count = 0;
  }
  System.out.println(average);
  return average;
 }

 public String getLetterGrade() {
  if (average >= A) {
   return "A";
  } else if (average >= B) {
   return "B";
  } else if (average >= C) {
   return "C";
  } else if (average >= D) {
   return "D";
  } else {
   return "F";
  }
 }
}
