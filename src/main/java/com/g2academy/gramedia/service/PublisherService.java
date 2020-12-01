package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.domain.Publisher;
import com.g2academy.gramedia.repository.BookRepository;
import com.g2academy.gramedia.repository.PublisherRepository;
import com.g2academy.gramedia.service.Dto.PublisherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    private final PublisherRepository repository;
    private final BookRepository bookRepository;

    PublisherService(PublisherRepository repository, BookRepository bookRepository){
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Publisher add(PublisherDto publisherDto){
        Publisher publisherE = Publisher.builder()
                .name(publisherDto.getName())
                .address(publisherDto.getAddress())
                .phone(publisherDto.getPhone())
                .url(publisherDto.getUrl())
                .build();
        return repository.save(publisherE);
    }

    public List<Publisher> findAll(){
        return repository.findAll();
    }

    public Optional<Publisher> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Book addBook(Long idPublisher, Long idBook){
        Optional<Publisher> pEntity = this.findById(idPublisher);
        Publisher publisher = pEntity.orElse(null);
        if (publisher != null){
            Optional<Book> bEntity = bookRepository.findById(idBook);
            Book book = bEntity.orElse(null);
            if (book!= null){
                publisher.addBook(book);
            }
            repository.save(publisher);
        }
        return null;
    }

    public Publisher updatePublisher(PublisherDto publisherDto, Long id){
        Optional<Publisher> pEntity = this.findById(id);
        Publisher publisher = pEntity.orElse(null);
        if (publisher != null){
            publisher.setName(publisherDto.getName());
            publisher.setAddress(publisherDto.getAddress());
            publisher.setPhone(publisherDto.getPhone());
            publisher.setUrl(publisherDto.getUrl());
            return repository.save(publisher);
        }
        return null;
    }

    public ResponseEntity<?> deletePublisher(Long id){
        return repository.findById(id).map(bookE -> {
            repository.delete(bookE);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new RuntimeException("Publisher tidak ditemukan"));
    }
}
