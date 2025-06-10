package ru.headache.backend.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.headache.backend.store.repositories.SongRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WeeklyPromotionScheduler {
    private final PromotionAlgorithm promotionAlgorithm;
    private final SongRepository songRepository;

    @Scheduled(cron = "0 0 0 * * MON") // Каждый понедельник в полночь
    public void runWeeklyPromotion() {
        List<PromotionCandidate> topCandidates = promotionAlgorithm.findTopUnpopularSongs();

        // Сохраняем или отправляем уведомления
        for (PromotionCandidate candidate : topCandidates) {
            System.out.println("Promoting: " + candidate.getSong().getName()+ " | Score: " + candidate.getScore());
            candidate.getSong().setFeatured(true);
            candidate.getSong().setPromotedUntil(LocalDateTime.now().plusDays(7));
        }

        // Сохраняем обновлённые песни в БД
        songRepository.saveAll(
                topCandidates.stream()
                        .map(PromotionCandidate::getSong)
                        .toList()
        );
    }
}
