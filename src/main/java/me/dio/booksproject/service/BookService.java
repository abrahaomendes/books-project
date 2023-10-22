package me.dio.booksproject.service;


import me.dio.booksproject.domain.model.Book;
import me.dio.booksproject.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book bookToCreate) {
        if (bookToCreate.getId() != null && bookRepository.existsById(bookToCreate.getId())) {
            throw new IllegalArgumentException("This book ID already exists");
        }
        return bookRepository.save(bookToCreate);
    }

}
