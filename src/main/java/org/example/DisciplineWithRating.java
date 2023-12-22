package org.example;

import java.util.ArrayList;
import java.util.List;

public class DisciplineWithRating {
    private Discipline discipline;
    private List<Mark> markList;

    public DisciplineWithRating(Discipline discipline){
        this.discipline = discipline;

        this.markList = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}
