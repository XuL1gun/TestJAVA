package OutputFiles;

import org.example.*;

import java.text.DecimalFormat;
import java.util.*;

public class OutputStudentsInAlphabet implements OutputStudentList {
    @Override
    public String outputStudent(StatisticTable statisticTable) {
        List<Student> studentList = statisticTable.getStudentList();
        StringBuilder result = new StringBuilder();

        Collections.sort(studentList);

        for (Student student : studentList) {
            int[] statistic = new int[5];
            setStaticsMark(student, statistic);
            double averageScore = calculateAverageScore(statistic);
            result.append(student.getSurName())
                    .append(" ")
                    .append(student.getName())
                    .append(" ")
                    .append(student.getLastName())
                    .append(" - | ");


            for (int count : statistic)
                result.append(count).append(" | ");

            result.append(getRoundNumber(averageScore)).append(" |\n");
        }


        return result.toString();
    }

    private void setStaticsMark(Student student, int[] statistic) {
        List<DisciplineWithRating> tableMark = student.getRatings();

        for (DisciplineWithRating discipline : tableMark) {
            List<Mark> markList = discipline.getMarkList();
            for (Mark mark : markList) {
                if (mark.ratingReference().getRatingReference() != 0)
                    statistic[Math.abs(mark.ratingReference().getRatingReference() - 5)]++;
                else
                    statistic[4]++;
            }
        }

    }

    private float calculateAverageScore(int[] statistic) {
        int sumMark = 0;
        int countMark = 0;
        int mark = 5;

        for (int i = 0; i < 4; i++){
            countMark += statistic[i];
            sumMark += statistic[i] * mark;
            mark--;
        }

        return (float) sumMark / countMark;
    }

    private String getRoundNumber(double num){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(num);
    }
}
