package GenerateFiles;

import org.example.*;

import java.util.*;

public final class GenerateStudentMarks {

    private static final int COUNT_MARKS = 5;
    private static final int MARKS_FOR_COURS = 5;

    private GenerateStudentMarks(){}

    public static void GenerateStudentGradeBook(Student[] students, Discipline[] disciplines){
        for (Student student : students) {
            List<DisciplineWithRating> studentGradeBook = student.getGradeBook();
            for (Discipline discipline : disciplines) {
                DisciplineWithRating disciplineWithRating = new DisciplineWithRating(discipline);
                int markForCourse = new Random().nextInt(MARKS_FOR_COURS);
                disciplineWithRating.getMarkList().add(new Mark(RatingReference.values()[markForCourse]));
                //studentGradeBook.put(discipline, new Mark(RatingReference.values()[markForCourse]));
                studentGradeBook.add(disciplineWithRating);
            }

            student.setGradeBook(studentGradeBook);
        }
    }

    public static void generateStudentJournay(Student[] students, Discipline[] disciplines) {
        for (Student student : students) {
            List<DisciplineWithRating> studentMarkList = student.getRatings();
            for (Discipline discipline : disciplines) {
                createStudentMarkForJournay(studentMarkList, discipline);
            }

            student.setRatings(studentMarkList);
        }
    }

    private static void createStudentMarkForJournay(List<DisciplineWithRating> studentMarkList, Discipline discipline) {
        int countMarks = new Random().nextInt(COUNT_MARKS);
        DisciplineWithRating disciplineWithRating = new DisciplineWithRating(discipline);
        studentMarkList.add(disciplineWithRating);

        for (int i = 0; i < countMarks; i++) {
            int mark = new Random().nextInt(MARKS_FOR_COURS);
            disciplineWithRating.getMarkList().add(new Mark(RatingReference.values()[mark]));
        }
    }
}

