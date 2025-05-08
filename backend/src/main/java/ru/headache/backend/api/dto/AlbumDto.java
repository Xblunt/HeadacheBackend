package ru.headache.backend.api.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class AlbumDto {
    private String uuid;
    private String name;
    private String authorUUID;
    private List<String> savedSongsUUIDs;
}
