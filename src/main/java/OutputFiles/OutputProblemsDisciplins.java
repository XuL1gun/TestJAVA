package OutputFiles;

import org.example.*;

import java.util.*;
import java.util.stream.Collectors;

public class OutputProblemsDisciplins implements OutputStudentList {
    @Override
    public String outputStudent(StatisticTable statisticTable) {
        StringBuilder result = new StringBuilder();
        List<Student> studentList = statisticTable.getStudentList();

        Map<Discipline, Integer> disciplineMap = getDisciplineList(studentList);

        disciplineMap = sortMapDiscipline(disciplineMap);

        for (Discipline discipline : disciplineMap.keySet())
            result.append(discipline.name())
                    .append("(")
                    .append(discipline.semester())
                    .append(") - ")
                    .append(disciplineMap.get(discipline)).append("\n");

        return result.toString();
    }

    private Map<Discipline, Integer> getDisciplineList(List<Student> studentList) {
        Map<Discipline, Integer> disciplineIntegerMap = new HashMap<>();

        for (Student student : studentList) {
            //Map<Discipline, Mark> disciplineMarkMap = student.getGradeBook();
            List<DisciplineWithRating> disciplineMarkList = student.getGradeBook();
            for (DisciplineWithRating disciplineWithRating : disciplineMarkList) {

                Discipline discipline = disciplineWithRating.getDiscipline();
                int mark = checkStudentMark(disciplineWithRating);

                if (disciplineIntegerMap.containsKey(discipline))
                    disciplineIntegerMap.put(discipline, disciplineIntegerMap.get(discipline) + mark);
                else if (mark != 0)
                    disciplineIntegerMap.put(discipline, 1);
            }
        }


        return disciplineIntegerMap;
    }

    private int checkStudentMark(DisciplineWithRating disciplineWithRating) {
        Mark studentMark = disciplineWithRating.getMarkList().getFirst();

        return (studentMark.ratingReference().getRatingReference() <= 2) ? 1 : 0;
    }

    private static Map<Discipline, Integer> sortMapDiscipline(Map<Discipline, Integer> disciplineMap) {
        return disciplineMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
    }
}
