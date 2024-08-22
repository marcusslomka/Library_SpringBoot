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

    //delete
}
