package com.utec.lab;

import com.utec.lab.classes.Calculator;
import com.utec.lab.classes.Pair;
import com.utec.lab.classes.Teacher;
import com.utec.lab.enums.TeacherType;

import java.util.List;
import java.util.logging.Logger;

public class App {
    public static void main( String[] args ) {
        var logger = Logger.getLogger(App.class.getName());
        var s = new Calculator(2020);
        s.addTeacher(2020, List.of(
                new Pair<>( new Teacher("Josefina", TeacherType.PROFESSOR_FT), true),
                new Pair<>( new Teacher("Edonisio", TeacherType.PROFESSOR_FT), true),
                new Pair<>( new Teacher("Edufasio", TeacherType.PROFESSOR_FT), false)
        ));
        s.addTeacher(2019, List.of(
                new Pair<>( new Teacher("Eduarda", TeacherType.PROFESSOR_FT), false),
                new Pair<>( new Teacher("Abelardo", TeacherType.PROFESSOR_FT), false),
                new Pair<>( new Teacher("Francisca", TeacherType.PROFESSOR_FT), false)
        ));

        var teachers = s.getAwesomeTeachers();
        logger.info("Profesores que estan de acuerdo con otorgar puntos extra");
        for(var teacher : teachers) {
            logger.info(teacher.getName());
        }
    }
}
