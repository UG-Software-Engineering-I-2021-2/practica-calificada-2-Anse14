package com.utec.lab;

import com.utec.lab.classes.Calculator;
import com.utec.lab.classes.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class CalculatorTests {
    @Test
    void fail_given_there_are_no_exams() {
        Calculator studentGradeCalculator = new Calculator(2019);

        final List<Pair<Integer, Float>> examsGrades = Collections.emptyList();
        final boolean hasReachedMinimumClasses = true;

        Assert.assertEquals(studentGradeCalculator.calculateGrades(examsGrades, hasReachedMinimumClasses), 0);
    }
}
