package ru.headache.backend.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "avg_rating")
    private Double avgRating;

    @Column(name = "url")
    private String url;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private SongStatus status;

    @ManyToOne
    @JoinColumn(name = "author_uuid")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "song_tags",
            joinColumns = @JoinColumn(name = "song_uuid"),
            inverseJoinColumns = @JoinColumn(name = "tag_uuid")
    )
    private List<Tag> tags;

    @OneToOne
    @JoinColumn(name = "file_uuid", referencedColumnName = "uuid")
    private File file;
}
