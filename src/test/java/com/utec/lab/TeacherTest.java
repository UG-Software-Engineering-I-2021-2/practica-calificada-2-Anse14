package com.utec.lab;

import com.utec.lab.classes.Teacher;
import com.utec.lab.enums.TeacherType;
import org.junit.Assert;
import org.junit.Test;

public class TeacherTest {
    @Test
    public void teacher_pt_creator() {
        var teacher = new Teacher("Juan", TeacherType.PROFESSOR_PT);
        Assert.assertEquals(2000, teacher.salary());
    }

    @Test
    public void teacher_ft_creator() {
        var teacher = new Teacher("Juan", TeacherType.PROFESSOR_FT);
        Assert.assertEquals(2500, teacher.salary());
    }

    @Test
    public void teacher_admin_creator() {
        var teacher = new Teacher("Juan", TeacherType.ADMINISTRATIVE);
        Assert.assertEquals(2100, teacher.salary());
    }
}
