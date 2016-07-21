package com.L05Inheritance.BookShop.models;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.3;
    }

}