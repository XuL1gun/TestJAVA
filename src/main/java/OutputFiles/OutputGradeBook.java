package OutputFiles;

import InputInformAboutStudent.InputInform;
import OutputToDocuments.OutputToSystem;
import org.example.*;

import java.util.List;
import java.util.Map;

public class OutputGradeBook implements OutputStudentList{
    @Override
    public String outputStudent(StatisticTable statisticTable) {
        OutputToSystem.outputString("Введите имя студента");

        String studentName = InputInform.getInform();
        Student student = statisticTable.getStudent(studentName);
        List<Teacher> teachers = statisticTable.getTeacgerList();

        String heading = "| Студент | Семестр | Дисциплина | Преподаватель | Оценка |\n";
        StringBuilder result = new StringBuilder(heading);

        List<DisciplineWithRating> studentGradeBook = student.getGradeBook();

        for (DisciplineWithRating disciplineWithRating: studentGradeBook){
            int mark = disciplineWithRating.getMarkList().getFirst().ratingReference().getRatingReference();
            Discipline discipline = disciplineWithRating.getDiscipline();

            if (mark < 3)
                continue;

            String markForGradeBook = convertMark(mark);
            String teacherName = getTeacherName(teachers, discipline);


            result.append(studentName).append(" | ")
                    .append(discipline.semester()).append(" | ")
                    .append(discipline.name()).append(" | ")
                    .append(teacherName).append("| ")
                    .append(markForGradeBook).append(" |\n");
        }

        return result.toString();
    }

    private String getTeacherName(List<Teacher> teachers, Discipline discipline){
        for (Teacher teacher: teachers){
            if (checkDisciplin(teacher, discipline))
                return teacher.getSurName() + " " + teacher.getName().charAt(0) + ". " +  teacher.getLastName().charAt(0) + ".";
        }

        return "";
    }

    private boolean checkDisciplin (Teacher teacher, Discipline discipline){
        List<Discipline> disciplines = teacher.getDisciplineList();

        for (Discipline teacherDisciplin: disciplines){
            if (discipline.equals(teacherDisciplin))
                return true;
        }

        return false;
    }

    private String convertMark(int mark){
        return switch (mark) {
            case 5 -> "Отлично";
            case 4 -> "Хорошо";
            default -> "Удовлетворительно";
        };
    }
}
