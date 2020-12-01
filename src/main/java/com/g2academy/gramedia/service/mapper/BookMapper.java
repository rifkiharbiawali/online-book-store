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

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", expression = "java(entity.getBookId())")
    @Mapping(target = "authorId", expression = "java(entity.getAuthor().getAuthorId())")
    @Mapping(target = "publisherId", expression = "java(entity.getPublisher().getPublisherId())")
    @Mapping(source = "author", target = "authorName", qualifiedByName = "getAuthorName")
    @Mapping(source = "author", target = "publisherName", qualifiedByName = "getPublisherName")

//    BookDto toDto(Book entity);
    Book toEntities(BookDto dto);

    List<BookDto> toDtos(List<Book> Entities);
    List<Book> toEntities(List<BookDto> dtos);

    @Named("getAuthorName")
    default String authorEntityGetAuthorId(Author authorEntity){
        return authorEntity.getName();
    }

    @Named("getPublisherName")
    default String authorEntityGetAuthorId(Publisher publisherEntity){
        return publisherEntity.getName();
    }
}
