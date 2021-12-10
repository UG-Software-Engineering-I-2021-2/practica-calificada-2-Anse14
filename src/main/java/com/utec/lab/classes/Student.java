package com.utec.lab.classes;

import com.utec.lab.enums.StudentType;

public class Student {
    private String name;
    private StudentType type;
    private int baseGrade;

    public Student(String name, StudentType type) {
        this.name = name;
        this.type = type;
        this.baseGrade = 11;
    }

    public Student(String name, StudentType type, int baseGrade) {
        this.name = name;
        this.type = type;
        this.baseGrade = baseGrade;
    }

    int grade() {
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
