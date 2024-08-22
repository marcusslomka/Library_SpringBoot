package de.supercode.thelibrary.repositories;

import de.supercode.thelibrary.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookRepository {
    public static long  actualid = 0;
    ArrayList<Book> booksDb;

    public BookRepository(){
        booksDb = new ArrayList<>();
    }

    //create es ist auch voll ok wenn man das gespeicherte buch stat void zurück gibt
    public void addBook(Book book){
        book.setId(actualid++);
        this.booksDb.add(book);
    }
    //read
    public Book getBook(long id){
        return this.booksDb.stream().filter(book->book.getId()==id).findFirst().orElseThrow();
    }

    public ArrayList<Book> getAllBooks(){
        return this.booksDb;
    }

    //update
//    public void updateBookByYear(long id,int year){
//       Book toUpdatedBook =  this.booksDb.stream()
//                .filter(b-> b.getId()==id).findFirst().orElseThrow();
//       toUpdatedBook.setYear(year);
//    }
//    public void updateBookByDiscription(long id,String discription){
//        Book toUpdatedBook =  this.booksDb.stream()
//                .filter(b-> b.getId()==id).findFirst().orElseThrow();
//        toUpdatedBook.setDescription(discription);
//    }
//    public void updateBookByTitle(long id, String title){
//        Book toUpdatedBook =  this.booksDb.stream()
//                .filter(b-> b.getId()==id).findFirst().orElseThrow();
//        toUpdatedBook.setTitle(title);
//    }
//    public void updateBookCompletly(long id,String title,int year, String discription){
//        Book toUpdatedBook =  this.booksDb.stream()
//                .filter(b-> b.getId()==id).findFirst().orElseThrow();
//        toUpdatedBook.setTitle(title);
//        toUpdatedBook.setYear(year);
//        toUpdatedBook.setDescription(discription);
//    }
    public void updateBook(Book book, long id){
        Book toUpdateBook = booksDb.stream()
                .filter(b -> b.getId()==id).findFirst().orElseThrow();

        toUpdateBook.setTitle(book.getTitle());
        toUpdateBook.setYear(book.getYear());
        toUpdateBook.setDescription(book.getDescription());
    }

    //delete
    public void deleteBook(long id){
        booksDb.removeIf(book -> book.getId()==id);

    }
}
