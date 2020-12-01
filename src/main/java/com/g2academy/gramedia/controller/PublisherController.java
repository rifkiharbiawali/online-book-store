package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.domain.Publisher;
import com.g2academy.gramedia.service.Dto.PublisherDto;
import com.g2academy.gramedia.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    private final PublisherService service;

    public PublisherController(PublisherService service){
        this.service = service;
    }

    @GetMapping("/publishers")
    public List<Publisher> getPublisher (){return service.findAll();}

    @GetMapping("/publishers/{id}")
    public Optional<Publisher> getIdAuthor(@PathVariable Long id) {return service.findById(id);}

    @PostMapping("/publishers")
    public Publisher addPublisher(@RequestBody PublisherDto publisherDto){
        return service.add(publisherDto);
    }

    @PutMapping("/publishers/books/{idPublisher}/{idBook}")
    public Book addBook(@PathVariable Long idPublisher, @PathVariable Long idBook){
        return service.addBook(idPublisher, idBook);
    }

    @PutMapping("/publishers/{id}")
    public Publisher updatePublisher(@RequestBody PublisherDto publisherDto, @PathVariable Long id){
        return service.updatePublisher(publisherDto, id);
    }

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Long id){
        return service.deletePublisher(id);
    }
}
