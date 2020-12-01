package com.g2academy.gramedia.service.Dto;

import lombok.*;

import java.util.Set;

//@Setter
//@Getter
//@NoArgsConstructor
@Value
@AllArgsConstructor
@Builder
public class AuthorDto {
    private String name;
    private String address;
    private String url;
    private Set<BookDto> bookDtos;
}
