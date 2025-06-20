package ru.headache.backend.api.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class PromotionRequestDto {
    private String uuid;
    private String songUUID;
    private String msg;
    private LocalDate dispatchTime;
    private LocalDate confirmationTime;
    private String status;
}
