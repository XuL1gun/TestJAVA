package org.example;

import GenerateFiles.GenerateStudentMarks;
import JSONFile.SetStudentsFromJSON;
import JSONFile.SetTeachersFromJSON;
import OutputFiles.OutputGradeBook;
import OutputFiles.OutputProblemsDisciplins;
import OutputFiles.OutputStudentsInAlphabet;
import OutputToDocuments.OutputToSystem;
import OutputToDocuments.WriteToExel;
import OutputToDocuments.WriteToWord;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Discipline[] disciplines = new Discipline[]{
                    new Discipline("Математика", 1),
                    new Discipline("Математика", 2),
                    new Discipline("Английский язык", 1),
                    new Discipline("Английский язык", 2),
                    new Discipline("Информатика", 1),
                    new Discipline("Физика", 1),
                    new Discipline("История", 1),
                    new Discipline("Матлог", 2),
                    new Discipline("ООП", 2),
                    new Discipline("CИАОД", 2)
            };
    private static Student[] students;
    private static Teacher[] teachers;


    public static void main(String[] args) {
        WriteToWord writeToWord = new WriteToWord();
        WriteToExel writeToExel = new WriteToExel();

        System.out.println("Загрузить тестовые данные: 1 - рандомно, 2 - из JSON файла");
        int n = scanner.nextInt();
        downLoadDate(n);

        StatisticTable statisticTable = new StatisticTable(teachers, students);
        if (n == 1){
            GenerateStudentMarks.generateStudentJournay(students, disciplines);
            GenerateStudentMarks.GenerateStudentGradeBook(students, disciplines);
        }

        System.out.println("Способ вывода по заданиям (1-3)");
        n = scanner.nextInt();
        String result;

        switch (n){
            case 1:
                OutputStudentsInAlphabet outputStudentList = new OutputStudentsInAlphabet();

                result = outputStudentList.outputStudent(statisticTable);

                OutputToSystem.outputString(result);
                writeToWord.writeToDocument(result);
                writeToExel.writeToDocument(result);
                break;
            case 2:
                OutputProblemsDisciplins outputProblemsDisciplins = new OutputProblemsDisciplins();

                result = outputProblemsDisciplins.outputStudent(statisticTable);

                OutputToSystem.outputString(result);
                writeToWord.writeToDocument(result);
                writeToExel.writeToDocument(result);
                break;
            case 3:
                OutputGradeBook outputGradeBook = new OutputGradeBook();

                result = outputGradeBook.outputStudent(statisticTable);

                OutputToSystem.outputString(result);
                writeToWord.writeToDocument(result);
                writeToExel.writeToDocument(result);
                break;
            default:
                break;
        }
    }

    private static void downLoadDate(int n){
        if (n == 1){
            students = new Student[]{
                new Student("Иванов", "Алексей", "Алексеевич"),
                        new Student("Петрова", "Екатерина", "Евгеньевна"),
                        new Student("Смирнов", "Михаил", "Сергеевич"),
                        new Student("Сидоров", "Николай", "Дмитриевич"),
                        new Student("Козлова", "Ольга", "Ивановна"),
            };

            teachers = new Teacher[]{
                    new Teacher("Соколовский", "Евгений", "Дмитриевич", disciplines[0], disciplines[1]),
                    new Teacher("Никитин-Петров", "Максим", "Александрович", disciplines[4], disciplines[7]),
                    new Teacher("Григорьева", "Алина", "Ивановна", disciplines[2], disciplines[3]),
                    new Teacher("Морозова-Смирнова", "Ольга", "Владимировна", disciplines[8], disciplines[9]),
                    new Teacher("Васильков", "Даниил", "Петрович", disciplines[5], disciplines[6]),
            };
        }else{
            students = new SetStudentsFromJSON().setStudentsList();
            teachers = new SetTeachersFromJSON().setTeachersList();
        }
    }
}