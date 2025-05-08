package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.headache.backend.api.dto.AlbumDto;
import ru.headache.backend.store.entities.Album;
import ru.headache.backend.store.entities.Song;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AlbumMapper {
    @Mapping(target = "authorUUID", source = "entity.author.uuid")
    @Mapping(target = "savedSongsUUIDs", source = "savedSongs", qualifiedByName = "mapSongToString")
    AlbumDto toDTO(Album entity);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "savedSongs", ignore = true)
    Album toEntity(AlbumDto dto);

    @Named("mapSongToString")
    default String mapSongToString(Song song){
        if(song == null) return null;
        return song.getUuid();
    }
}
