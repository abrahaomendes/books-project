package me.dio.booksproject.domain.repository;

import me.dio.booksproject.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
