package org.example;


import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    private final String surName;
    private final String name;
    private final String lastName;

    //private Map<Discipline, List<Mark>> markList;
    private List<DisciplineWithRating> ratings;
    private List<DisciplineWithRating> gradeBook;

    public Student(String surName, String name, String lastName) {
        this.surName = surName;
        this.name = name;
        this.lastName = lastName;

        ratings = new ArrayList<>();
        gradeBook = new ArrayList<>();
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<DisciplineWithRating> getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(List<DisciplineWithRating> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public List<DisciplineWithRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<DisciplineWithRating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compareTo(Student o) {
        String first = this.getSurName() + this.getName() + this.getLastName();
        String second = o.getSurName() + o.getName() + o.getLastName();
        return first.compareToIgnoreCase(second);

    }
}
