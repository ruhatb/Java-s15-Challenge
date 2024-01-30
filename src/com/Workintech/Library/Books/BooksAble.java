package com.Workintech.Library.Books;
import java.util.List;
public interface BooksAble {

    void addBook(Books book);
    void deleteBook(int bookId);
    int getId();
    String getTitle();
    String getWriter();
    List<Books> getBooks();

}
