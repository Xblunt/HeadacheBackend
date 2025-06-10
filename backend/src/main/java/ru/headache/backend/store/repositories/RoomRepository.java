package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.headache.backend.store.entities.PromotionRequest;
import ru.headache.backend.store.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,String> {
    Optional<Room> findByUuid(String uuid);
}

