package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.store.entities.AudioState;
import ru.headache.backend.store.repositories.AudioStateRepository;
import ru.headache.backend.store.repositories.RoomRepository;
import ru.headache.backend.store.repositories.SongRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AudioStateService {

    private final AudioStateRepository audioRepo;
    private final SongRepository songRepo;
    private final RoomRepository roomRepo;

    public void updateAudioState(String roomId, String songId, int position, boolean isPlaying) {
        AudioState state = audioRepo.findById(roomId)
                .orElseGet(() -> new AudioState());

        state.setSong(songRepo.findById(songId).get());
        state.setPosition(position);
        state.setPlaying(isPlaying);
        state.setRoom(roomRepo.findByUuid(roomId).get());

        audioRepo.save(state);
    }

    public Optional<AudioState> getAudioState(String roomId) {
        return audioRepo.findById(roomId);
    }
}