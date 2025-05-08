package ru.headache.backend.api.dto;

import lombok.*;
import ru.headache.backend.store.entities.CooperationStatus;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class CooperationRequestDto {
    private String uuid;
    private String msg;
    private LocalDate dispatchTime;
    private CooperationStatus status;
    private String authorUUID;
    private String labelUUID;
}
