package com.Workintech.Library.Library;

import com.Workintech.Library.Library.Books;

public class Academic extends Books {
    public Academic(int id, String title, String writer) {
        super(id, title, writer, category);
    }

    @Override
    public double calculatePrice() {
        return 8.0;
    }
}
