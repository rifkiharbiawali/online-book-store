package com.g2academy.gramedia.service;

import com.g2academy.gramedia.domain.Author;
import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.repository.AuthorRepository;
import com.g2academy.gramedia.repository.BookRepository;
import com.g2academy.gramedia.service.Dto.AuthorDto;
import com.g2academy.gramedia.service.Dto.BookDto;
import com.g2academy.gramedia.service.mapper.AuthorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AuthorService {
    private final AuthorRepository repository;
    private final BookRepository bookRepository;

    AuthorService(AuthorRepository repository, BookRepository bookRepository){
        this.repository = repository;
        this.bookRepository= bookRepository;
    }

    private Author save(Author entity){
        return repository.save(entity);
    }

    Function<List<Author>, List<AuthorDto>> toDtos(){
        return (x) -> AuthorMapper.INSTANCE.toDtos(x);
    }

    Function<List<Author>, ResponseEntity<List<AuthorDto>>> getAll(){
        return (x) -> new ResponseEntity<List<AuthorDto>>(this.toDtos().apply(x), HttpStatus.OK);
    }

    public ResponseEntity<List<AuthorDto>> findAll(){
        return this.getAll().apply(repository.findAll());
    }
//    public List<AuthorDto> getAllAuthors() {
//        return AuthorMapper.INSTANCE.toDtos(repository.findAll());
//    }


    @Transactional
    public Author addAuthor(AuthorDto authorDto){
        Author authorE = Author.builder()
                .name(authorDto.getName())
                .address(authorDto.getAddress())
                .url(authorDto.getUrl())
                .build();

        for (BookDto bookDto : authorDto.getBookDtos()){
                Book bookE = Book.builder()
                        .author(authorE)
                        .isbn(bookDto.getIsbn())
                        .year(bookDto.getYear())
                        .title(bookDto.getTitle())
                        .price(bookDto.getPrice())
                        .build();
                authorE.addBook(bookE);
            }
        return repository.save(authorE);
    }

    public Author editAuthor(AuthorDto authorDto, Long id){
        Optional<Author> aEntity = this.findById(id);
        Author author = aEntity.orElse(null);
        if (author != null){
            author.setName(authorDto.getName());
            author.setAddress(authorDto.getAddress());
            author.setUrl(authorDto.getUrl());
            return repository.save(author);
        }
        return null;
    }

    public ResponseEntity<?> deleteAuthor(Long id){
        return repository.findById(id).map(authorEntity -> {
            repository.delete(authorEntity);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new RuntimeException("Author tidak ditemukan"));
    }

//    public List<Author> findAll(){
//        return repository.findAll();
//    }

    public Optional<Author> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Book> findBook(Long id) { return bookRepository.findById(id);}

    @Transactional
    public Book addBook(BookDto bookDto, Long id){
        Optional<Author> aEntity = this.findById(id);
        Author author = aEntity.orElse(null);
        if (author != null){
            Book bookE = Book.builder()
                    .isbn(bookDto.getIsbn())
                    .title(bookDto.getTitle())
                    .year(bookDto.getYear())
                    .price(bookDto.getPrice())
                    .author(author)
                    .build();
            return bookRepository.save(bookE);
        }
      return null;
    }

    public Book updateBook(BookDto bookDto, Long idAuthor, Long idBook){
        Optional<Author> aEntity = this.findById(idAuthor);
        Author author = aEntity.orElse(null);
        if (author != null){
            Optional<Book> bEntity = bookRepository.findById(idBook);
            Book book = bEntity.orElse(null);
            if (book != null){
                book.setIsbn(bookDto.getIsbn());
                book.setTitle(bookDto.getTitle());
                book.setYear(bookDto.getYear());
                book.setPrice(bookDto.getPrice());
                return bookRepository.save(book);
            }
            repository.save(author);
        }
        return null;
    }

//    public Book deleteBook(Long idAuthor, Long idBook){
//        Optional<Author> aEntity = this.findById(idAuthor);
//        Author author = aEntity.orElse(null);
//        if (author!=null){
//            Optional<Book> bEntity = bookRepository.findById(idBook);
//            Book book = bEntity.orElse(null);
//            if (book != null){
//                bookRepository.delete(book);
//            }
//            repository.save(author);
//        }
//        return null;
//
//    }

    public ResponseEntity<?> deleteBook(Long id){
        return bookRepository.findById(id).map(bookE -> {
            bookRepository.delete(bookE);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new RuntimeException("Book tidak ditemukan"));
    }

}
