package com.g2academy.gramedia.repository;

import com.g2academy.gramedia.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.isbn LIKE %?1%")
    List<Book> findIsbn(String keyword);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %?1%")
    List<Book> findTitle(String keyword);

    @Query("SELECT b FROM Book b WHERE b.author.name LIKE %?1%")
    List<Book> findAuthor(String keyword);

    @Query("SELECT b FROM Book b WHERE b.publisher.name LIKE %?1%")
    List<Book> findPublisher(String keyword);
}
