package com.myblog;

public class Registration {
    String name;
    int age;
    String city;
    int salary;

    public Registration(String name, int age, String city, int salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public int getSalary() {
        return salary;
    }
}
