package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.headache.backend.api.dto.AlbumDto;
import ru.headache.backend.api.mapper.AlbumMapper;
import ru.headache.backend.store.entities.Album;
import ru.headache.backend.store.repositories.AlbumRepository;
import ru.headache.backend.store.repositories.SongRepository;
import ru.headache.backend.store.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository repository;
    private final AlbumMapper mapper;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    public List<AlbumDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public AlbumDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public AlbumDto save(AlbumDto dto)
    {
        Album album = mapper.toEntity(dto);
        if (Objects.nonNull(dto.getAuthorUUID()))
            album.setAuthor(userRepository.findById(dto.getAuthorUUID()).orElse(null));
        if (!CollectionUtils.isEmpty(dto.getSavedSongsUUIDs()))
            album.setSavedSongs(songRepository.findAllByUuidIn(dto.getSavedSongsUUIDs()));
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public Boolean delete(String uuid)
    {
        if (Objects.isNull(repository.findByUuid(uuid))) return Boolean.FALSE;
        repository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
