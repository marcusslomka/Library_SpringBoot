package de.supercode.thelibrary.controller;

import de.supercode.thelibrary.entities.Book;
import de.supercode.thelibrary.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ArrayList<Book> getAllBooks(@RequestParam(required = false) Long bookid){
            return bookService.getAllBooks();
    }
    //?bookid=2 @RequestParams
    @GetMapping("/{id}")
    public Book getABook(@PathVariable long id){
        return bookService.getABook(id);
    }

//    @GetMapping("/book")
//    public Book getAnotherBook(@RequestParam(required = false) Long bookid){
//        System.out.println(bookid);
//        return bookService.getABook(0);
//    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

   @PutMapping("/{id}")
    public void updateBook (@RequestBody Book book,@PathVariable long id){bookService.updateBook(book,id);}

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable long id){ bookService.deleteBook(id);}
}
