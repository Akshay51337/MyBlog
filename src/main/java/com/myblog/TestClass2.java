package com.myblog;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestClass2 {
    public static void main(String[] args) {
      /*  List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 13);
        List<String> collect = list.stream().map(s -> s.toString()).filter(a -> a.startsWith("1")).collect(Collectors.toList());
        System.out.println(collect);*/

      /*  List<Integer> list = Arrays.asList(10, 3,10, 5, 0, 4, 0, 2, 0, 1, 10, 1, 0, 2, 4);
        LinkedHashSet<Integer> a = new LinkedHashSet<Integer>();
        List<Integer> collect = list.stream().filter(i -> !a.add(i)).collect(Collectors.toList());
        System.out.println(collect);*/

      /* Consumer<Integer> val = number-> System.out.println(number);
       val.accept(100)*/;
/*        List<String> list = Arrays.asList("mike", "akshay", "kiran", "raj");
       Consumer<String> val=name->System.out.println(name);
       list.forEach(val);*/
/*
        Supplier<Integer> x = ()->new Random().nextInt(500);
        Integer i = x.get();
        System.out.println(i);*/

        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        List<Integer> collect = list.stream().filter(a -> a % 2 == 0).map(s -> s * s).collect(Collectors.toList());
        System.out.println(collect);
    }
}
