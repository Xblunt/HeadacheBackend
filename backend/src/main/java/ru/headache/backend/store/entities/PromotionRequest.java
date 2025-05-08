package ru.headache.backend.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promotion_request")
public class PromotionRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "song_uuid")
    private Song song;

    @Column(name = "msg")
    private String msg;

    @Column(name = "dispatch_time")
    @Temporal(TemporalType.DATE)
    private LocalDate dispatchTime;

    @Column(name = "confirmation_time")
    @Temporal(TemporalType.DATE)
    private LocalDate confirmationTime;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private PromotionStatus status;
}
