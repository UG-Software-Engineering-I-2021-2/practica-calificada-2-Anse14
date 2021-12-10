package com.utec.lab;

import com.utec.lab.classes.Student;
import com.utec.lab.enums.StudentType;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void student_undergraduate_creator() {
        var student = new Student(StudentType.UNDERGRADUATE);
        Assert.assertEquals(11, student.grade());
    }

    @Test
    public void student_master_creator() {
        var student = new Student(StudentType.MASTER);
        Assert.assertEquals(12, student.grade());
    }

    @Test
    public void student_phd_creator() {
        var student = new Student(StudentType.PHD);
        Assert.assertEquals(13, student.grade());
    }
}
