package com.g2academy.gramedia.service.mapper;

import com.g2academy.gramedia.domain.Author;
import com.g2academy.gramedia.service.Dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = BookMapper.class)
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toDto(Author entity);
    Author toEntity(AuthorDto dto);

    List<AuthorDto> toDtos(List<Author> entities);
    List<Author> toEntities(List<Author> dtos);
}
