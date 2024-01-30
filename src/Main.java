
import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;
import com.Workintech.Library.Library.Library;
import com.Workintech.Library.Students.StudentType;
import com.Workintech.Library.Students.Students;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Books> bookMap = new HashMap<>();


        Books book = new Books(1, "Java Programming", "Yazar1", BookCategory.ACADEMIC);
        for (int i = 1; i <= 5; i++) {
            bookMap.put(i, book);
        }
        for (int i = 31; i <= 36; i++) {
            bookMap.put(i, new Books(i, "Academic" + i, "Yazar" + i, BookCategory.ACADEMIC));
        }

        for (int i = 6; i <= 20; i++) {
            bookMap.put(i, new Books(i, "Novel" + i, "Yazar" + i, BookCategory.NOVELS));
        }

        for (int i = 21; i <= 30; i++) {
            bookMap.put(i, new Books(i, "History" + i, "Yazar" + i, BookCategory.HISTORY));
        }

        Library library = new Library();

        for (Books b : bookMap.values()) {
            library.addBook(b);
        }

        List<Books> allBooks = library.getBooks();
        for (Books b : allBooks) {
            System.out.println(b.getId() + ": " + b.getTitle() + " - " + b.getWriter() + " - " + b.getCategory());
        }

        Books book11 = library.searchBookById(11);
        if (book11 != null) {
            System.out.println("11. ide olan kitap: " + book11.getTitle());
        } else {
            System.out.println("Kitap bulunamadı.");
        }

        Books book15 = library.searchBookByTitle("Novel15");
        if (book15 != null) {
            System.out.println("Kitap (title: Book15): " + book15.getId());
        } else {
            System.out.println("Kitap bulunamadı.");
        }


        Students licenceStudent = new Students(100, "Ali", StudentType.LICENCE);
        library.addStudent(licenceStudent);

        Students masterStudent = new Students(201, "Emre", StudentType.MASTER);
        library.addStudent(masterStudent);

    }
}