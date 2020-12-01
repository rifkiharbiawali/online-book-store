package com.g2academy.gramedia.service.Dto;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class PublisherDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String url;
    private Set<BookDto> books;
}
