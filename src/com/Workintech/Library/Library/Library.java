package com.Workintech.Library.Library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Library implements LibraryAble {

    private List<Books> booksList;
    private Map<Integer, Books> books;


    public Library(List<Books> booksList, Map<Integer, Books> books) {
        this.booksList = booksList;
        this.books = books;
    }

    public Library() {
        this.books = new HashMap<>();
    }


}
