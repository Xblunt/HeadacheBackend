package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.headache.backend.api.dto.SongDto;
import ru.headache.backend.store.entities.Song;

@Mapper(componentModel = "spring",uses = {TagMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SongMapper {
    @Mapping(target = "authorUUID", source = "entity.author.uuid")
    @Mapping(target = "fileUUID", source = "entity.file.uuid")
    SongDto toDTO(Song entity);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "file",  ignore = true)
    Song toEntity(SongDto dto);
}
