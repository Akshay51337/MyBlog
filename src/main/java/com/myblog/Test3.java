package com.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<Employee> employees =Arrays.asList(new Employee("mike",34,"mumbai"),
                new Employee("akshay",25,"kolkata"),
                new Employee("shyam",31,"Goa"),
                new Employee("sam",34,"Kolkata"));
        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge()));
        for (Map.Entry<Integer,List<Employee>> entry :collect.entrySet()){
            Integer age = entry.getKey();
            List<Employee> employeesWithAge = entry.getValue();
            System.out.println("age:"+age+"---");
            for (Employee e: employeesWithAge){
                System.out.println(e.getCity());
                System.out.println(e.getName());
            }
        }


        /*for(Employee emp:employees){
            List<Employee> employees1 = collect.get(emp.getAge());
            System.out.println(employees1);
            for(Employee ex : employees1){
                System.out.println(ex.getName());
                System.out.println(ex.getCity());
                System.out.println(ex.getAge());
            }
        }*/
    }

}
