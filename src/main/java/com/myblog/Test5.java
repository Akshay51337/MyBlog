package com.myblog;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {
    public static void main(String[] args) {
        List<Students> list = Arrays.asList(new Students(3.5,"akshay"),
                new Students(6.5,"krishan"),
                new Students(7.5,"durgesh"),
                new Students(2.5,"suresh"),
                new Students(1.5,"virat"));
        List<String> name = list.stream().filter(a -> a.getGPA()>=3.5).map(a -> a.getName().toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        System.out.println(name);

    }
}
