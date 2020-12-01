package com.g2academy.gramedia.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.g2academy.gramedia.YMConvert;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
@AuditTable("books_audit")
@Table(name = "books")
public class Book extends BaseEntity<String> implements Serializable {

    @Column(name = "isbn")
    private String isbn;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "year", columnDefinition = "mediumint")
    @Convert(converter = YMConvert.class)
    private YearMonth year;

    @Column(name = "title")
    private String title;

    @Column(name = "price", precision = 19, scale = 4)
    private Double price;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Wb> wbs;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bb> bbs;
}
