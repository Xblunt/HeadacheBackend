package ru.headache.backend.api.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.headache.backend.api.dto.PromotionRequestDto;
import ru.headache.backend.store.entities.PromotionRequest;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PromotionRequestMapper {
    @Mapping(target = "songUUID", source = "entity.song.uuid")
    PromotionRequestDto toDTO(PromotionRequest entity);

    @Mapping(target = "song", ignore = true)
    PromotionRequest toEntity(PromotionRequestDto dto);
}
