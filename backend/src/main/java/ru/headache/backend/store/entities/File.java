package ru.headache.backend.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file")
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Lob
    private byte[] data;

    @Column(name = "extension")
    @Enumerated(EnumType.ORDINAL)
    private FileExtension extension;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private FileType type;
}
