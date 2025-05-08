package ru.headache.backend.api.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class UserDto {
    private String uuid;
    private String login;
    private String password;
    private List<String> roles;
    private boolean isAccountNonLocked;
    private boolean isActive;
    private String description;
    private String imgFileUUID;
    private String phoneNumber;
    private String email;
    private LocalDate birthDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate lastVisitDate;
    private Double avgRating;
    private List<String> savedSongsUUIDs;
}
