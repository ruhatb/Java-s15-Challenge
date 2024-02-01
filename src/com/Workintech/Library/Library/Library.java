package com.Workintech.Library.Library;

import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;
import com.Workintech.Library.Students.StudentType;
import com.Workintech.Library.Students.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Library implements LibraryAble{
    private List<Books> bookList;
    private List<Students> studentList;

    private Map<Integer, Integer> rentedBooks;

    public Library() {
        this.bookList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    private Students getStudentByNo(int studentNo) {
        for (Students student : studentList) {
            if (student.getStudentNo() == studentNo) {
                return student;
            }
        }
        return null;
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
    public Map<BookCategory, Double> calculateRent() {
        return null;
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
    public void showBookStatus() {
        for (Map.Entry<Integer, Integer> entry : rentedBooks.entrySet()) {
            int bookId = entry.getKey();
            int studentNo = entry.getValue();

            Books book = searchBookById(bookId);
            Students student = getStudentByNo(studentNo);

            if (book != null && student != null) {
                System.out.println("Kitap (" + book.getTitle() + ") " +
                        "ID: " + book.getId() +
                        " öğrenci (" + student.getName() +
                        " - Student No: " + student.getStudentNo() +
                        ") tarafından alınmıştır. Fiyatı: " + book.getPrice());
            }
        }
    }

    public  double calculateRentalFee(int studentNo, int bookId) {
        Students student = findStudent(studentNo);
        Books book = searchBookById(bookId);

        if (student != null && book != null) {
            double baseFee = book.getPrice();

            double rentalFee;
            if (student.getStudentType() == StudentType.MASTER) {
                rentalFee = student.calculateRentalFee(baseFee * 1.2);
            } else {
                rentalFee = student.calculateRentalFee(baseFee);
            }

            return rentalFee;
        }

        return -1;
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

    public List<Students> getStudents() {
        return new ArrayList<>(studentList);
    }
}
