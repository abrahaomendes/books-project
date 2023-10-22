package me.dio.booksproject.controller;

import me.dio.booksproject.domain.model.Book;
import me.dio.booksproject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        var book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }
    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        var bookCreated = bookService.create(book);
        return ResponseEntity.created(null).body(bookCreated);
    }


}
