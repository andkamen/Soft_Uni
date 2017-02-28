package bookhut.entities;

import java.util.Date;

public class Book {
    private long id;

    private String title;

    private String author;

    private int pages;

    private Date date;

    public Book() {
    }

    public Book(String title, String author, int pages, Date date) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
        this.setDate(date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
