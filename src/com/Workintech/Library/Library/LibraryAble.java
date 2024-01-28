package com.Workintech.Library.Library;

public interface LibraryAble {



    Books getBookId(int id);
    Books getBookTitle(String title);
    Books getBookWriter(String writer);

    void deleteBook(int id);
    void listBookCategory(String category);
    void listBookWriter(String writer);
    void listBookTitle(String title);


}
