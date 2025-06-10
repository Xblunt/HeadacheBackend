package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.headache.backend.store.entities.AudioState;

public interface AudioStateRepository extends JpaRepository<AudioState, String> {
}