package ru.headache.backend.api.dto;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ChatMessageDTO {
    private String uuid;
    private String sender;
    private String content;
    private LocalDateTime timestamp;
    private String roomId;
}
