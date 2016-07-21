package com.L05Inheritance.BookShop.models;

import com.sun.javafx.binding.StringFormatter;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        if (title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        if (author == null || !this.isAuthorNameValid(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private boolean isAuthorNameValid(String author) {
        String[] authorInfo = author.split("\\s+");
        if (authorInfo.length > 1 && Character.isDigit(authorInfo[1].charAt(0))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f",this.getPrice()))
                .append(System.lineSeparator());
        return sb.toString();

    }
}