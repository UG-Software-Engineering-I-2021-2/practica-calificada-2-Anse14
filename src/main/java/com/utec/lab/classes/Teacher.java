package com.utec.lab.classes;

import com.utec.lab.enums.TeacherType;

public class Teacher {
    private String name;
    private TeacherType type;
    private int monthlyBaseSalary;
    private int commission;
    private int bonus;

    public Teacher(String name, TeacherType type) {
        this.name = name;
        this.type = type;
        this.monthlyBaseSalary = 2000;
        this.commission = 500;
        this.bonus = 100;
    }

    public Teacher(String name, TeacherType type, int monthlyBaseSalary, int commission, int bonus) {
        this.name = name;
        this.type = type;
        this.monthlyBaseSalary = monthlyBaseSalary;
        this.commission = commission;
        this.bonus = bonus;
    }

    public int salary() {
        switch (type) {
            case PROFESSOR_PT:
                return monthlyBaseSalary;
            case PROFESSOR_FT:
                return monthlyBaseSalary + commission;
            case ADMINISTRATIVE:
                return monthlyBaseSalary + bonus;
            default:
                throw new IllegalArgumentException("Empleado incorrecto");
        }
    }

    public String getName() {
        return name;
    }
}
