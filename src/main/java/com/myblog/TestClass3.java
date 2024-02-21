package com.myblog;



import org.hibernate.dialect.Ingres9Dialect;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class TestClass3 {
    public static void main(String[] args) {
        List<Registration> list = Arrays.asList(new Registration("AKSHAY", 25, "Mumbai", 25000),
                new Registration("UMAR", 26, "Bangalore", 26000),
                new Registration("NIKHAT", 24, "Chennai", 27000),
                new Registration("NAZNEEN", 24, "Chennai", 28000)

        );
        //based on city
//        Map<String, List<EmployeeB>> collectCity = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
//        System.out.println(collectCity);

        //based on age
        Map<Integer, List<Registration>> collectAge = list.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for(Map.Entry<Integer,List<Registration>> entry: collectAge.entrySet()) {
            Integer age = entry.getKey();
            List<Registration> employeesWithAge = entry.getValue();
            System.out.println("age:" + age + "----");
            for (Registration e : employeesWithAge) {
                System.out.println(e.getCity());
                System.out.println(e.getName());
            }
        }}
    }
