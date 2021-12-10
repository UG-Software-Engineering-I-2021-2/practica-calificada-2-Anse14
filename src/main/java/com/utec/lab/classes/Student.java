package com.utec.lab.classes;

import com.utec.lab.enums.StudentType;

public class Student {
    private StudentType type;
    private int baseGrade;

    public Student(StudentType type) {
        this.type = type;
        this.baseGrade = 11;
    }

    public Student(StudentType type, int baseGrade) {
        this.type = type;
        this.baseGrade = baseGrade;
    }

    public int grade() {
        switch (type) {
            case UNDERGRADUATE:
                return baseGrade;
            case MASTER:
                return baseGrade + 1;
            case PHD:
                return baseGrade + 2;
            default:
                throw new IllegalArgumentException("Empleado incorrecto");
        }
    }
}
