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
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = Collections.emptyList();
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(0.0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void calculate_same_grade_given_one_single_exam_and_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 5f));
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void calculate_average_grade_given_different_exam_grades_and_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(
                new Pair<>(10, 4f),
                new Pair<>(10, 6f),
                new Pair<>(10, 2f),
                new Pair<>(10, 8f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f)
        );
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(5, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void round_up_to_2_decimals_given_odd_exam_grades_and_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(
                new Pair<>(50, 4f),
                new Pair<>(50, 5f)
        );
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(4.5f, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void fail_when_there_are_no_exams_and_has_not_attended_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = Collections.emptyList();
        final boolean hasReachedMinimumClasses = false;

        Assert.assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void fail_given_one_single_exam_but_not_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 5f));
        final boolean hasReachedMinimumClasses = false;

        Assert.assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void fail_given_different_exam_grades_but_not_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(
                new Pair<>(10, 4f),
                new Pair<>(10, 6f),
                new Pair<>(10, 2f),
                new Pair<>(10, 8f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f),
                new Pair<>(10, 0f),
                new Pair<>(10, 10f)
        );
        final boolean hasReachedMinimumClasses = false;

        Assert.assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void fail_given_odd_exam_grades_but_attending_the_minimum_classes() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 5f));
        final boolean hasReachedMinimumClasses = false;

        Assert.assertEquals(0, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    // Weight

    @Test
    public void validate_all_exam_grades_weight_below_100() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(
                new Pair<>(10, 4f),
                new Pair<>(10, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(-2, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void validate_all_exam_grades_weight_over_100() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(
                new Pair<>(90, 4f),
                new Pair<>(20, 6f)
        );
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(-1, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    // hasToRaiseOnePoint

    @Test
    public void not_increase_one_extra_point_if_there_is_not_any_benevolent_teacher_in_the_year_to_calculate_grades() {
        Calculator studentGradeCalculator = new Calculator(2019);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 9.8f));
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(9.8f, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void increase_one_extra_point_if_there_is_any_benevolent_teacher_in_the_year_to_calculate_grades() {
        Calculator studentGradeCalculator = new Calculator(2020);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 5f));
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(6, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }

    @Test
    public void maintain_10_as_the_maximum_grade_even_if_increasing_one_extra_point() {
        Calculator studentGradeCalculator = new Calculator(2020);
        studentGradeCalculator.addTeacher(2020, List.of(
                new Pair<>(new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>(new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        studentGradeCalculator.addTeacher(2019, List.of(
                new Pair<>(new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>(new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        final List<Pair<Integer, Float>> examsGrades = List.of(new Pair<>(100, 9.8f));
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(10, studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 10);
    }
}
