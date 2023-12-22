package org.example;

public enum RatingReference {
    GREATE(5),
    GOOD(4),
    SATISFACTORY(3),
    UNSATISFACTORY(2),
    ABSENCE(0);
    private final int mark;
    RatingReference(int mark) {
        this.mark = mark;
    }
    public int getRatingReference() {
        return this.mark;
    }
}
