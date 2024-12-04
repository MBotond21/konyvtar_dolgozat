package com.example.konyvtar;

public class Konyv {
    private String title;
    private String author;
    private Integer page_count;

    public Konyv(String author, Integer page_count, String title) {
        this.author = author;
        this.page_count = page_count;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPage_count() {
        return page_count;
    }
}
