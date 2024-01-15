package com.myblog;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
/*        Predicate<Integer> val = s->s%2==0;
        boolean test = val.test(10);
        System.out.println(test);*/


   /*     Predicate <String> val1= k->k.equals("mike");
        boolean mike = val1.test("mike");
        System.out.println(mike);*/

        List<Integer> numbers = Arrays.asList(10, 15, 12, 17, 18, 20);
        List<Integer> collect = numbers.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());
       /* System.out.println(collect);*/

        List<String> string = Arrays.asList("miket", "akshay", "ram", "bharat", "lakshman","akshay","Perry");
        List<String> data1 = string.stream().filter(s -> s.equals("akshay")).collect(Collectors.toList());
        List<String> data2 = string.stream().filter(s -> s.startsWith("l")).collect(Collectors.toList());
        List<String> data3 = string.stream().filter(s -> s.endsWith("t")).collect(Collectors.toList());
    /*    Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number:");
        int i = scan.nextInt();
       System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        Predicate<Integer> val2 = a->a%2==0;
        boolean test1 = val2.test(i);
        System.out.println(test1);*/
        
       Function<Integer,Integer> result = i->i+10;
        Integer data = result.apply(10);
        System.out.println(data);

       /* List<Integer> mite = Arrays.asList(10, 20, 30, 60, 90);
        List<Integer> in = mite.stream().map(i -> i + 10).collect(Collectors.toList());
        System.out.println(in);*/
        /*List<String> mite = Arrays.asList("miket", "akshay", "ram", "bharat", "lakshman","akshay","Perry");
        List<String> in = mite.stream().map(i->i.toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        System.out.println(in);*/
        List<String> mite = Arrays.asList("miket", "akshay", "ram", "bharat", "lakshman","akshay","perry");
        List<String> in = mite.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(in);

        /*List<Integer> cam = Arrays.asList(10, 20, 5, 1, 3,5,10, 30, 40);
        List<Integer> collect1 = cam.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(collect1);*/
        List<Integer> cam = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> collect1 = cam.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        int sum = collect1.stream().map(i -> i * i).mapToInt(Integer::intValue).sum();
        /*System.out.println(sum);
        List<String> list = Arrays.asList("akshay", "ram", "krishna", "hm","ak");
        String collect2 = list.stream().filter(i -> i.length() >= 3).collect(Collectors.joining(" "));
        System.out.println(collect2);*/

        /*List<Integer> k = Arrays.asList(10, 20, 1, 3, 5, 7, 9, 15, 4, 6, 9, 7, 3, 6, 43, 47);
        List<Integer> collect3 = k.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        System.out.println(collect3);*/
        List<String> s = Arrays.asList("akshay", "ram", "krishna", "asaa","ak");
        Map<Integer, List<String>> collect2 = s.stream().collect(Collectors.groupingBy(String::length));
        collect2.forEach((a, n) ->
        System.out.println("Names with length " + a + ": " + n));
    }


}
