package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.api.dto.FileDto;
import ru.headache.backend.api.mapper.FileMapper;
import ru.headache.backend.store.repositories.FileRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;
    private final FileMapper mapper;

    public List<FileDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public FileDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public FileDto save(FileDto dto)
    {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public Boolean delete(String uuid)
    {
        if (Objects.isNull(repository.findByUuid(uuid))) return Boolean.FALSE;
        repository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
