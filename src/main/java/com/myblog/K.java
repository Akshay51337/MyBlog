package com.myblog;

public class K {
    public static void main(String[] args) {
        System.out.println("Before calling test method");
        K.test();
        System.out.println("After calling test method");
        System.out.println("Additional line after test method call");
    }

    public static void test() {
        System.out.println("Inside test method, about to call anotherMethod");
        anotherMethod();
        System.out.println("Back in test method after calling anotherMethod");
    }

    public static void anotherMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside anotherMethod: " + i);
        }
    }
}
