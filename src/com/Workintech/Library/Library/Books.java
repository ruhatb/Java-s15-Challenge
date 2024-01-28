package com.Workintech.Library.Library;

import java.util.List;
import java.util.Map;

public  class Books extends Library implements BooksAble {

    private int id;
    private String title;
    private String writer;

    private double price;
    private BookStatus status;
    private BookCategory category;

    public Books(List<Books> booksList, Map<Integer, Books> books, int id, String title, String writer, double price, BookStatus status, BookCategory category) {
        super(booksList, books);
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Books(int id, String title, String writer, double price, BookStatus status, BookCategory category) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.status = status;
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

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public void addBook(int id, String title, String writer, BookCategory category) {
        switch (category) {
            case ACADEMIC:
                books.put(id, new Academic(id, title, writer));
                break;
            case NOVELS:
                books.put(id, new Novels(id, title, writer));
                break;
            case HISTORY:
                books.put(id, new History(id, title, writer));
                break;
            default:
                System.out.println("Category haven't now.");
        }


    }



        @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", category=" + category +
                '}';
    }


}
