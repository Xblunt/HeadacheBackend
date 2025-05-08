package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.headache.backend.api.dto.CooperationRequestDto;
import ru.headache.backend.store.entities.СooperationRequest;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CooperationRequestMapper {
    @Mapping(target = "authorUUID", source = "entity.author.uuid")
    @Mapping(target = "labelUUID", source = "entity.label.uuid")
    CooperationRequestDto toDTO(СooperationRequest entity);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "label", ignore = true)
    СooperationRequest toEntity(CooperationRequestDto dto);
}
