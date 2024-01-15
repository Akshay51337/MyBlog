package com.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(new Employee("akshay", 25, "gondia"),
                new Employee("kiran", 35, "jaipur"),
                new Employee("khushi", 36, "jaipur"),
                new Employee("kiran", 37, "jaipur"),
                new Employee("aman", 38, "jaipur"),
                new Employee("himanshu", 40, "jaipur"));
        List<String> collect = list.stream().map(e->e.getName()+","+e.getCity()+","+e.getAge()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
