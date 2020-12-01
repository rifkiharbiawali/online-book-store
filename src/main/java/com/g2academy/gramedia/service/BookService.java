package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    BookService(BookRepository repository){
        this.repository = repository;
    }

    public List<Book> findAll(){return repository.findAll();}

    public List<Book> findIsbn(String isbn){
        if (isbn != null){
            return repository.findIsbn(isbn);
        }
        return null;
    }

    public List<Book> findTitle(String title){
        if (title != null){
            return repository.findTitle(title);
        }
        return null;
    }

    public List<Book> findAuthor(String author){
        if (author != null){
            return repository.findAuthor(author);
        }
        return null;
    }

    public List<Book> findPublisher(String publisher){
        if (publisher != null){
            return repository.findPublisher(publisher);
        }
        return null;
    }


}
