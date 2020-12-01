package com.g2academy.gramedia.service.Dto;

import lombok.*;

import java.time.YearMonth;

//@Setter
//@Getter
//@NoArgsConstructor
@Value
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String isbn;
    private YearMonth year;
    private String title;
    private Double price;
    private Long AuthorId;
    private Long PublisherId;
//    private PublisherDto publisher;
//    private AuthorDto author;
}
