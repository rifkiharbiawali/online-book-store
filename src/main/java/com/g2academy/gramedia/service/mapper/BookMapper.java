package com.g2academy.gramedia.service.mapper;

import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.service.Dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDto(Book entity);
    Book toEntities(BookDto dto);

    List<BookDto> toDtos(List<Book> Entities);
    List<Book> toEntities(List<BookDto> dtos);
}
