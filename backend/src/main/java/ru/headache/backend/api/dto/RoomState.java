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
public class RoomState {
    private String roomId;
    private AudioStateDTO audioState;
    private List<ChatMessageDTO> chatHistory;
}
