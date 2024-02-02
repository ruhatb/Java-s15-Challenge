
import com.Workintech.Library.Books.BookCategory;
import com.Workintech.Library.Books.Books;
import com.Workintech.Library.Library.Library;
import com.Workintech.Library.Students.StudentType;
import com.Workintech.Library.Students.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//new ArrayList<>(), new HashMap<>(), new HashMap<>() bunu  librarye yazmalımıyız ? hata veriyor library2 için
        Library library = new Library();
        Library library2 = new Library();

        // Oğrenci olusumu
        Students student = new Students(101, "Ali", StudentType.MASTER);


        library.initializeLibraryWithBooks();
        library.addStudent(student);

        library.showBookList();

        // Hangi kitabı ?
        Scanner scanner = new Scanner(System.in);

        System.out.print("Öğrenci tipini seçin (1-Master, 2-Licence): ");
        int studentTypeChoice = scanner.nextInt();
        StudentType selectedStudentType = (studentTypeChoice == 1) ? StudentType.MASTER : StudentType.LICENCE;

        System.out.print("Hangi kitabı almak istediğinizi belirtin (Kitap ID): ");
        int selectedBookId = scanner.nextInt();

        // Kitabı Öğrenciye Ekleme -- hocaya sor ?
        Books selectedBook = library.searchBookById(selectedBookId);
        if (selectedBook != null) {
            student.addBookToStudent(selectedBook);
        } else {
            System.out.println("Kitap bulunamadı.");
        }



        Map<Integer, Books> bookMap = new HashMap<>();


        // KITAP OLUSTURUP EKLEDİM

        Books book = new Books(1, "Java Programming", "Yazar1", BookCategory.ACADEMIC,15);
        for (int i = 1; i <= 5; i++) {
            bookMap.put(i, book);
        }
        for (int i = 31; i <= 36; i++) {
            bookMap.put(i, new Books(i, "Academic" + i, "Yazar" + i, BookCategory.ACADEMIC,15));
        }

        for (int i = 6; i <= 20; i++) {
            bookMap.put(i, new Books(i, "Novel" + i, "Yazar" + i, BookCategory.NOVELS,20));
        }

        for (int i = 21; i <= 30; i++) {
            bookMap.put(i, new Books(i, "History" + i, "Yazar" + i, BookCategory.HISTORY,25));
        }


        //KITAP IDsine ve TİTLE GÖRE ARAMA YAPTIM

      // Burada scanner ? olmalı mı nasıl olur.. liste burda deneme amaclı ..
        System.out.println("****************************************************************************");
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

        System.out.println("******************************************************");


        library2.initializeLibraryWithBooks();

        System.out.print("Aramak istediğiniz kitabın ID'sini girin: ");
        int searchBookId = scanner.nextInt();
        Books foundBook = library2.searchBookById(searchBookId);
        if (foundBook != null) {
            System.out.println("Aranan kitap bulundu: " + foundBook.getTitle() +
                    " - Yazar: " + foundBook.getWriter() +
                    " - Kategori: " + foundBook.getCategory());
        } else {
            System.out.println("Kitap bulunamadı.");
        }


        System.out.println("********************************************************");

        //ÖGRENCİ EKLEDİM ÖGRENCİ LİSTESİ OLUSTURDUM

        Students student1 = new Students(100, "Ali", StudentType.LICENCE);
        Students student2 = new Students(201, "Emre", StudentType.MASTER);
        Students student3 = new Students(105, "Ahmet", StudentType.LICENCE);
        Students student4 = new Students(205, "Sevgi", StudentType.MASTER);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);
        library.addStudent(student4);


    }
}