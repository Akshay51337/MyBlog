package com.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book1 {
    public static void main(String[] args) {
        List<Book> list = Arrays.asList(new Book("The man", "Jay", 358),
                new Book("The Hunt", "Kishan", 400),
                new Book("Treasure", "Manish", 700),
                new Book("Mission Imposible", "Omprakash", 600)
        );
        List<String> collect = list.stream().filter(a -> a.getAuthor().equalsIgnoreCase("jay")).map(a -> a.getTitle()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
