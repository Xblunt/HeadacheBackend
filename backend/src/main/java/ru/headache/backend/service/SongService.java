package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.api.dto.SongDto;
import ru.headache.backend.api.mapper.SongMapper;
import ru.headache.backend.store.entities.Song;
import ru.headache.backend.store.repositories.FileRepository;
import ru.headache.backend.store.repositories.SongRepository;
import ru.headache.backend.store.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository repository;
    private final SongMapper mapper;
    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    public List<SongDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public SongDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public SongDto save(SongDto dto)
    {
        Song song = mapper.toEntity(dto);
        if (!Objects.isNull(dto.getAuthorUUID()))
            song.setAuthor(userRepository.findById(dto.getAuthorUUID()).orElse(null));
        if (!Objects.isNull(dto.getFileUUID()))
            song.setFile(fileRepository.findById(dto.getFileUUID()).orElse(null));
        return mapper.toDTO(repository.save(song));
    }

    public Boolean delete(String uuid)
    {
        if (Objects.isNull(repository.findByUuid(uuid))) return Boolean.FALSE;
        repository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
