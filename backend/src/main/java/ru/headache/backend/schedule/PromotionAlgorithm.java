package ru.headache.backend.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.store.entities.PromotionRequest;
import ru.headache.backend.store.entities.Song;
import ru.headache.backend.store.repositories.PromotionRequestRepository;
import ru.headache.backend.store.repositories.SongRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionAlgorithm {
    private final SongRepository songRepo;
    private final PromotionRequestRepository requestRepo;

    public List<PromotionCandidate> findTopUnpopularSongs() {
        List<Song> unpopular = songRepo.findByPlayCountLastWeekLessThan(10);
        List<PromotionRequest> approved = requestRepo.findByStatus(PromotionRequest.Status.APPROVED);

        List<PromotionCandidate> candidates = new ArrayList<>();
        for (Song song : unpopular) {
            int score = calculateScore(song, approved.stream().anyMatch(r -> r.getSong().getUuid().equals(song.getUuid())));
            candidates.add(new PromotionCandidate(song, score));
        }

        return candidates.stream()
                .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore()))
                .limit(10)
                .toList();
    }

    private int calculateScore(Song song, boolean isPromoted) {
        int score = 0;
        if (song.getPlayCountLastWeek() < 10) score += 4;
        if (Duration.between(song.getCreatedAt(), LocalDateTime.now()).toDays() < 7) score += 3;
        if (isPromoted) score += 5;
        return score;
    }
}
