package com.Workintech.Library.Library;

import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;

import java.util.List;
import java.util.Map;
public interface LibraryAble {
    void addBook(Books book);
    void deleteBook(int bookId);
    List<Books> getBooks();
    Map<BookCategory, Double> calculateRent();

    Books searchBookById(int bookId);
    Books searchBookByTitle(String title);

    void showBookStatus();
    public void showBookList();

    public void initializeLibraryWithBooks();
}
