package com.utec.lab.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private final Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers;
    private final int yearToCalculate;

    public Calculator(int yearToCalculate) {
        this.allYearsTeachers = new HashMap<>();
        this.yearToCalculate = yearToCalculate;
    }

    public void addTeacher(Integer year, List<Pair<Teacher, Boolean>> teachers) {
        allYearsTeachers.put(year, teachers);
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (examsStudents.isEmpty()) {
            return 0f;
        }

        var hasToIncreaseOneExtraPoint = false;

        for (var yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate != yearlyTeachers.getKey()) {
                continue;
            }

            var teachers = yearlyTeachers.getValue();

            for (var teacher : teachers) {
                if (Boolean.FALSE.equals(teacher.second())) {
                    continue;
                }
                hasToIncreaseOneExtraPoint = true;
            }

        }

        var gradesSum = 0f;
        var gradesWeightSum = 0;

        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
            gradesWeightSum += examGrade.first();
        }

        if (gradesWeightSum > 100) {
            return -1f;
        }
        if (gradesWeightSum < 100) {
            return -2f;
        }

        if (!hasReachedMinimumClasses) {
            return 0f;
        }

        if (!hasToIncreaseOneExtraPoint) {
            return gradesSum;
        }

        return Float.min(10f, gradesSum + 1);
    }

    public List<Teacher> getAwesomeTeachers() {
        List<Teacher> awesomeTeachers = new ArrayList<>();
        for(var yearlyTeachers : allYearsTeachers.entrySet()) {
            var teachers = yearlyTeachers.getValue();
            for (var teacher : teachers) {
                if(Boolean.TRUE.equals(teacher.second())) {
                    awesomeTeachers.add(teacher.first());
                }
            }
        }
        return awesomeTeachers;
    }
}
