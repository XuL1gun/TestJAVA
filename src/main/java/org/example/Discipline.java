package org.example;

public record Discipline(String name, int semester) {

    @Override
    public boolean equals(Object obj) {
        Discipline discipline = (Discipline) obj;

        if (this.name().equals(discipline.name()) && this.semester() == discipline.semester())
            return true;

        return false;
    }
}
