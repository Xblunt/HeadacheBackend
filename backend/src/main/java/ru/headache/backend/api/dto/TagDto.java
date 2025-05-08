package ru.headache.backend.api.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class TagDto {
    private String uuid;
    private String tagName;
}
