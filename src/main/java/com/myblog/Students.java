package com.myblog;

public class Students {
    private double GPA;
    private String name;

    public Students(double GPA, String name) {
        this.GPA = GPA;
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public String getName() {
        return name;
    }
}
