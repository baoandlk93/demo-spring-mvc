package org.example.demospringmvc.entity;

public class Blog {
    private int id;
    private String name;
    private String content;
    private String author;
    private String date;

    public Blog() {
    }

    public Blog(int id, String name, String content, String author, String date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
