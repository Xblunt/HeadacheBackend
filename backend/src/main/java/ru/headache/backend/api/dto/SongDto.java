package ru.headache.backend.api.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import ru.headache.backend.store.entities.File;
import ru.headache.backend.store.entities.SongStatus;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class SongDto {
    private String uuid;
    private String name;
    private Double avgRating;
    private String url;
    private SongStatus status;
    private String authorUUID;
    private List<TagDto> tags;
    private String fileUUID;
}
