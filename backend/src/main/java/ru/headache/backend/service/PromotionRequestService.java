package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.api.dto.PromotionRequestDto;
import ru.headache.backend.api.mapper.PromotionRequestMapper;
import ru.headache.backend.store.entities.PromotionRequest;
import ru.headache.backend.store.repositories.PromotionRequestRepository;
import ru.headache.backend.store.repositories.SongRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromotionRequestService {
    private final PromotionRequestRepository repository;
    private final PromotionRequestMapper mapper;
    private final SongRepository songRepository;

    public List<PromotionRequestDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public PromotionRequestDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public PromotionRequestDto save(PromotionRequestDto dto)
    {
        PromotionRequest entity = mapper.toEntity(dto);
        if (Objects.nonNull(dto.getSongUUID()))
            entity.setSong(songRepository.findById(dto.getSongUUID()).orElse(null));
        if (Objects.isNull(dto.getDispatchTime()))
            entity.setDispatchTime(LocalDate.now());
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public Boolean delete(String uuid)
    {
        if (Objects.isNull(repository.findByUuid(uuid))) return Boolean.FALSE;
        repository.deleteById(uuid);
        return Boolean.TRUE;
    }
}
