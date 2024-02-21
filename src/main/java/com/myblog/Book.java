package com.myblog;

public class Book {
    String title;
    String author;
    int price;
    public Book(String title, String author, int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }
}
