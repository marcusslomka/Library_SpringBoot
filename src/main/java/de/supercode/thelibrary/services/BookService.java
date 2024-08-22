package de.supercode.thelibrary.services;

import de.supercode.thelibrary.entities.Book;
import de.supercode.thelibrary.repositories.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    //Instanzvariable
    BookRepository bookRepository;

    //Konstruktor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Methoden
    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public ArrayList<Book> getAllBooks(){
       return bookRepository.getAllBooks();
    }

    public Book getABook(long id){
        return bookRepository.getBook(id);
    }

    public void updateBook(Book book, long id){
        bookRepository.updateBook(book,id);
    }
    public void deleteBook (long id){
        bookRepository.deleteBook(id);
    }
}
