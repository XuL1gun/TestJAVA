package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticTable {
    private final List<Teacher> teachersList;

    private final List<Student> studentList;

    public StatisticTable(Teacher[] teachers, Student[] students){
        teachersList = new ArrayList<>();
        teachersList.addAll(Arrays.stream(teachers).toList());

        studentList = new ArrayList<>();
        studentList.addAll(Arrays.stream(students).toList());
    }

    public List<Teacher> getTeacgerList() {
        return teachersList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Student getStudent(String fullStudentName){

        for (Student student: studentList) {
            String studentName = student.getSurName() + " " + student.getName() + " " + student.getLastName();

            if (studentName.equals(fullStudentName))
                return student;
        }

        return null;
    }
}
