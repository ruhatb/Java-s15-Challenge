package com.Workintech.Library.Library;

import com.Workintech.Library.Library.BookCategory;

public interface BooksAble {

  void addBook(int id, String title, String writer, BookCategory category );
  double calculatePrice();
  String booksList();
  double bookPrice();

  boolean booksStatus();

  String getWriter();
  String getTitle();
}
