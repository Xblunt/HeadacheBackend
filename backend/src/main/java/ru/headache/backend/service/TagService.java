package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.api.dto.TagDto;
import ru.headache.backend.api.mapper.TagMapper;
import ru.headache.backend.store.repositories.TagRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;
    private final TagMapper mapper;

    public List<TagDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public TagDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public TagDto save(TagDto dto)
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
