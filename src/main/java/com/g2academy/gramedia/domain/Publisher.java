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
@AuditTable("publisher_audit")
@Table(name = "publisher")
public class Publisher extends BaseEntity<String> implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "url")
    private String url;

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    public void addBook(Book book){
        if (books == null){
            books = new HashSet<Book>();
        }
        books.add(book);
        book.setPublisher(this);
    }
}
