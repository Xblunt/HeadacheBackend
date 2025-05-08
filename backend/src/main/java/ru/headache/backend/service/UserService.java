package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.headache.backend.api.dto.UserDto;
import ru.headache.backend.api.mapper.UserMapper;
import ru.headache.backend.store.entities.User;
import ru.headache.backend.store.repositories.RoleRepository;
import ru.headache.backend.store.repositories.SongRepository;
import ru.headache.backend.store.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final SongRepository songRepository;
    private final RoleRepository roleRepository;

    public List<UserDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public UserDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public UserDto save(UserDto dto)
    {
        User user = mapper.toEntity(dto);
        user = repository.save(user);
        if (!CollectionUtils.isEmpty(dto.getRoles()))
            user.setRoles(roleRepository.findAllByRoleIn(dto.getRoles()));
        if (dto.getSavedSongsUUIDs() != null)
            user.setSavedSongs(songRepository.findAllByUuidIn(dto.getSavedSongsUUIDs()));
        return mapper.toDTO(repository.save(user));
    }

    public Boolean delete(String uuid)
    {
        if (Objects.isNull(repository.findByUuid(uuid))) return Boolean.FALSE;
        repository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
