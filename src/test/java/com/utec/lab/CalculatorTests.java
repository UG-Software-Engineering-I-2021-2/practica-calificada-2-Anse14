package com.utec.lab;

import com.utec.lab.classes.Calculator;
import com.utec.lab.classes.Pair;
import com.utec.lab.classes.Teacher;
import com.utec.lab.enums.TeacherType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class CalculatorTests {
    @Test
    public void fail_given_there_are_no_exams() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>( new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>( new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>( new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>( new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>( new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>( new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = Collections.emptyList();
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(0.0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }
}
