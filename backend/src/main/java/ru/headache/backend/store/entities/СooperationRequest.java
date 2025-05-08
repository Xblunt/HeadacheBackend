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
@Table(name = "cooperation_request")
public class СooperationRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "msg")
    private String msg;

    @Column(name = "dispatch_time")
    @Temporal(TemporalType.DATE)
    private LocalDate dispatchTime;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private CooperationStatus status;

    @ManyToOne
    @JoinColumn(name = "author_uuid")
    private User author;

    @ManyToOne
    @JoinColumn(name = "label_uuid")
    private User label;
}
