package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.headache.backend.api.dto.FileDto;
import ru.headache.backend.store.entities.File;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FileMapper {
    FileDto toDTO(File entity);
    File toEntity(FileDto dto);
}
