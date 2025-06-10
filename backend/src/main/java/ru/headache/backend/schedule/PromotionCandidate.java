package ru.headache.backend.schedule;

import ru.headache.backend.store.entities.Song;

public class PromotionCandidate {
    private Song song;
    private int score;

    public PromotionCandidate(Song song, int score) {
        this.song = song;
        this.score = score;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

