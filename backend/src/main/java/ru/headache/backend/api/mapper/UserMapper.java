package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.headache.backend.api.dto.UserDto;
import ru.headache.backend.store.entities.Role;
import ru.headache.backend.store.entities.Song;
import ru.headache.backend.store.entities.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleToString")
    @Mapping(target = "savedSongsUUIDs", source = "savedSongs", qualifiedByName = "mapSongToString")
    UserDto toDTO(User entity);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "savedSongs", ignore = true)
    User toEntity(UserDto dto);

    @Named("mapRoleToString")
    default String mapRoleToString(Role role){
        if(role == null) return null;
        return role.getRole();
    }
    @Named("mapSongToString")
    default String mapSongToString(Song song){
        if(song == null) return null;
        return song.getUuid();
    }
}
