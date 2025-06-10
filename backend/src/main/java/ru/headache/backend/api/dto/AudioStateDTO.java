package ru.headache.backend.api.dto;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class AudioStateDTO {
    private String songId;
    private int position;
    private boolean isPlaying;
    private String roomId;
}
