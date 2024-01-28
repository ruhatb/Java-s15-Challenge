package com.Workintech.Library.Library;

import com.Workintech.Library.Library.Books;

public class History extends Books {
    public History(int id, String title, String writer) {
        super(id, title, writer, category);
    }

    @Override
    public double calculatePrice() {
        return 10.0;
    }
}
