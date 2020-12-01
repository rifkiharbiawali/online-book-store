package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService service;

    BookController(BookService service){
        this.service = service;
    }

    @GetMapping("/books")
    public List<Book> getAll(){return service.findAll();}

    @GetMapping("/books/isbn/{keyword}")
    public List<Book> getByIsbn(@PathVariable String keyword){
        return service.findIsbn(keyword);
    }

    @GetMapping("/books/title/{keyword}")
    public List<Book> getByTitle(@PathVariable String keyword){
        return service.findTitle(keyword);
    }

    @GetMapping("/books/author/{keyword}")
    public List<Book> getByAuthor(@PathVariable String keyword){
        return service.findAuthor(keyword);
    }

    @GetMapping("/books/publisher/{keyword}")
    public List<Book> getByPublisher(@PathVariable String keyword){
        return service.findPublisher(keyword);
    }
}
