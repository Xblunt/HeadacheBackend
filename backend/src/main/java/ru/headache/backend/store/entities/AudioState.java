package ru.headache.backend.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "audio_state")
public class AudioState {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "position")
    private int position;

    @Column(name = "is_playing")
    private boolean isPlaying;

    @ManyToOne
    @JoinColumn(name = "song_uuid")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "room_uuid")
    private Room room;



}
