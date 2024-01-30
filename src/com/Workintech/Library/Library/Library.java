package com.Workintech.Library.Library;

import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;
import com.Workintech.Library.Students.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Library implements LibraryAble{
    private List<Books> bookList;
    private List<Students> studentList;

    public Library() {
        this.bookList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }


    @Override
    public void addBook(Books book) {
        bookList.add(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookList.removeIf(book -> book.getId() == bookId);
    }

    @Override
    public List<Books> getBooks() {
        return new ArrayList<>(bookList);
    }

    @Override
    public Books searchBookById(int bookId) {
        for (Books book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }


    @Override
    public Books searchBookByTitle(String title) {
        for (Books book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    @Override
    public Map<BookCategory, Double> calculateRent() {
        Map<BookCategory, Double> feesMap = new HashMap<>();

        for (Books book : bookList) {
            BookCategory category = book.getCategory();
            double currentFee = feesMap.getOrDefault(category, 0.0);
            feesMap.put(category, currentFee + calculateFeeForBook(book));
        }

        return feesMap;
    }

    private double calculateFeeForBook(Books book) {

        return 15.0;
    }

    public void addStudent(Students student) {
        studentList.add(student);
    }

    public Students findStudent(int studentNo) {
        for (Students student : studentList) {
            if (student.getStudentNo() == studentNo) {
                return student;
            }
        }
        return null;
    }
}
