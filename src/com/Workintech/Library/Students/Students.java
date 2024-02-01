package com.Workintech.Library.Students;

import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;

import java.util.ArrayList;
import java.util.List;

public class Students implements StudentAble {
    private int studentNo;
    private String name;
    private StudentType studentType;

    private List<Books> books;

    public Students(int studentNo, String name, StudentType studentType) {
        this.studentNo = studentNo;
        this.name = name;
        this.studentType = studentType;
        this.books = new ArrayList<>();
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    @Override
    public double calculateRentalFee(int bookId) {
        BookCategory bookCategory = getBookCategoryById(bookId);

        double baseFee = 3.0;
        switch (bookCategory) {
            case HISTORY:
                return baseFee * 1.5;
            case ACADEMIC:
                return baseFee * 0.8;
            case NOVELS:
                return baseFee * 1.9;
            default:
                return baseFee;
        }
    }

    // Kitap kategorisini ID'ye göre
    private BookCategory getBookCategoryById(int bookId) {
        Books book = searchBookById(bookId);
        return (book != null) ? book.getCategory() : null;
    }

    // Search Metotu Hocaya sor yine map ?
    private Books searchBookById(int bookId) {

        for (Books book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void addBookToStudent(Books book) {
        books.add(book);
        System.out.println(book.getTitle() + " kitabı öğrenciye eklendi.");
    }
}
