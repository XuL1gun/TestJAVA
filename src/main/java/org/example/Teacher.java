package org.example;

import java.util.*;

public class Teacher {
    private final String surName;
    private final String name;
    private final String lastName;

    private List<Discipline> disciplineList;

    public Teacher(String surName, String name, String lastName, Discipline ...disciplines) {
        this.surName = surName;
        this.name = name;
        this.lastName = lastName;

        disciplineList = new ArrayList<>();
        disciplineList.addAll(List.of(disciplines));
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

    public List<Discipline> getDisciplineList(){return disciplineList;}

}
