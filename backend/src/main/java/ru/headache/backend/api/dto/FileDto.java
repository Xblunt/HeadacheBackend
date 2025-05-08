package ru.headache.backend.api.dto;

import lombok.*;
import ru.headache.backend.store.entities.FileExtension;
import ru.headache.backend.store.entities.FileType;


@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class FileDto {
    private String uuid;
    private byte[] data;
    private FileExtension extension;
    private FileType type;
}
