package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.api.dto.CooperationRequestDto;
import ru.headache.backend.api.mapper.CooperationRequestMapper;
import ru.headache.backend.store.entities.СooperationRequest;
import ru.headache.backend.store.repositories.CooperationRequestRepository;
import ru.headache.backend.store.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CooperationRequestService {
    private final CooperationRequestRepository repository;
    private final CooperationRequestMapper mapper;
    private final UserRepository userRepository;

    public List<CooperationRequestDto> getAll()
    {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CooperationRequestDto getByUUID(String uuid)
    {
        return repository.findByUuid(uuid).map(mapper::toDTO).orElse(null);
    }

    public CooperationRequestDto save(CooperationRequestDto dto)
    {
        СooperationRequest entity = mapper.toEntity(dto);
        if (Objects.nonNull(dto.getAuthorUUID()))
            entity.setAuthor(userRepository.findById(dto.getAuthorUUID()).orElse(null));
        if (Objects.nonNull(dto.getLabelUUID()))
            entity.setLabel(userRepository.findById(dto.getLabelUUID()).orElse(null));
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
