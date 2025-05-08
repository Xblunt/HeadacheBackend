package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.headache.backend.api.dto.TagDto;
import ru.headache.backend.store.entities.Tag;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TagMapper {
    TagDto toDTO(Tag entity);
    Tag toEntity(TagDto dto);
}
