package ru.headache.backend.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_uuid")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "album_songs",
            joinColumns = @JoinColumn(name = "album_uuid"),
            inverseJoinColumns = @JoinColumn(name = "song_uuid")
    )
    private List<Song> savedSongs;
}
