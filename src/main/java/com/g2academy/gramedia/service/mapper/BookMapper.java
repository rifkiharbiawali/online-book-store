package com.g2academy.gramedia.service.mapper;

import com.g2academy.gramedia.domain.Author;
import com.g2academy.gramedia.domain.Book;
import com.g2academy.gramedia.domain.Publisher;
import com.g2academy.gramedia.service.Dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "authorId", expression = "java(entity.getAuthor().getAuthorId())")
    @Mapping(source = "author", target = "authorId", qualifiedByName = "getAuthorId")

    @Named("getAuthorId")
    default Long authorEntityGetAuthorId(Author authorEntity){
        return authorEntity.getAuthorId();
    }

    BookDto toDto(Book entity);
    Book toEntities(BookDto dto);

    List<BookDto> toDtos(List<Book> Entities);
    List<Book> toEntities(List<BookDto> dtos);



}
