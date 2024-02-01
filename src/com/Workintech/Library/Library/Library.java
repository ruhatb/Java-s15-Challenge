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



    @Override
    public void initializeLibraryWithBooks() {
        // Mainde mi eklemelyim Burdaki gibi mi Hocaya sor.. ?
        Books book1 = new Books(1, "Book1", "Writer1", BookCategory.HISTORY, 10.0);
        Books book2 = new Books(2, "Book2", "Writer2", BookCategory.ACADEMIC, 15.0);
        Books book3 = new Books(3, "Book3", "Writer3", BookCategory.NOVELS, 20.0);
        Books book4 = new Books(4, "Book4", "Writer4", BookCategory.HISTORY, 12.0);
        Books book5 = new Books(5, "Book5", "Writer5", BookCategory.NOVELS, 18.0);

        addBook(book1);
        addBook(book2);
        addBook(book3);
        addBook(book4);
        addBook(book5);
    }

    @Override
    public void showBookList() {
        System.out.println("Kitap Listesi:");
        for (Books book : bookList) {
            System.out.println("ID: " + book.getId() + " - Title: " + book.getTitle() + " - Writer: " + book.getWriter() + " - Category: " + book.getCategory() + " - Price: " + book.getPrice());
        }
    }
}
