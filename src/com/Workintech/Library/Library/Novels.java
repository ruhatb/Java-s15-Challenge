package com.Workintech.Library.Library;

import com.Workintech.Library.Library.Books;

public class Novels extends Books {
    public Novels(int id, String title, String writer) {
        super(id, title, writer, category);
    }

    @Override
    public double calculatePrice() {
        return 5.0;
    }
}
