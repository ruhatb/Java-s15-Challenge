package com.Workintech.Library.Books;

public class Books {
    private int id;
    private String title;
    private String writer;
    private BookCategory category;


    public Books(int id, String title, String writer, BookCategory category) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public BookCategory getCategory() {
        return category;
    }
}
