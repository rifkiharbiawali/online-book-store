package com.g2academy.gramedia.controller;

import com.g2academy.gramedia.domain.Author;
import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.service.AuthorService;
import com.g2academy.gramedia.service.Dto.AuthorDto;
import com.g2academy.gramedia.service.Dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
//@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController (AuthorService service){
        this.service = service;
    }

//    @GetMapping("/authors")
//    public ResponseEntity<List<AuthorDto>>  getAllAuthors() {
//        return new ResponseEntity<List<AuthorDto>>(service.getAllAuthors(), HttpStatus.OK) ;
//    }

    Function<List<AuthorDto>, ResponseEntity<List<AuthorDto>>> getAll(){
        return (x) -> new ResponseEntity<List<AuthorDto>>(x, HttpStatus.OK);
    }
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDto>>  getAllAuthors() {
        return getAll().apply((List<AuthorDto>) service.findAll());
    }


//    @GetMapping("/authors")
//    public List<Author> getAllAuthor(){
//        return service.findAll();
//    }

    @GetMapping("/authors/{id}")
    public Optional<Author> getIdAuthor(@PathVariable Long id) {return service.findById(id);}

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody AuthorDto authorDto){
        return service.addAuthor(authorDto);
    }

    @PutMapping("/authors/{id}")
    public Author editAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        return service.editAuthor(authorDto, id);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        return service.deleteAuthor(id);
    }

    @PutMapping("/authors/books/{id}")
    public Book addBook(@RequestBody BookDto bookDto, @PathVariable Long id){
        return service.addBook(bookDto, id);
    }

    @PutMapping("/authors/books/{idAuthor}/{idBook}")
    public Book updateBook(@RequestBody BookDto bookDto, @PathVariable Long idAuthor, @PathVariable Long idBook){
        return service.updateBook(bookDto, idAuthor, idBook);
    }

    @PutMapping("/authors/delete-books/{idBook}")
    public ResponseEntity<?> deleteBook(@PathVariable Long idBook){
        return service.deleteBook(idBook);
    }
//    @GetMapping("/authors1")
//    public AuthorDto findById() {
//        AuthorDto authorDto = AuthorDto.builder()
//                .address("Rawamangun Timur Blok D/5131")
//                .url("angga@gmail.com")
//                .name("Angga")
//                .build();
//
//        BookDto book1 = BookDto.builder()
//                .isbn("ISBN-001")
//                .title("Habis Gelap Terbitlah Terang")
//                .price(100.0)
//                .year(YearMonth.of(2017, 7))
//                .build();
//
//        BookDto book2 = BookDto.builder()
//                .isbn("ISBN-002")
//                .title("Dari Sisi Terang")
//                .price(112.0)
//                .year(YearMonth.of(2019, 1))
//                .build();
//
//        authorDto.addBook(book1);
//        authorDto.addBook(book2);
//
//        return authorDto;
//    }

}
