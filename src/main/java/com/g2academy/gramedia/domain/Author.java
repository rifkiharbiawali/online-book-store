package com.g2academy.gramedia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
@AuditTable("authors_audit")
@Table(name = "authors")
public class Author extends BaseEntity<String> implements Serializable {

    public Long getAuthorId(){
        return id;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "url")
    private String url;

    @JsonManagedReference
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    public void addBook(Book book){
        if (books == null){
            books = new HashSet<Book>();
        }
        books.add(book);
        book.setAuthor(this);
    }
}
