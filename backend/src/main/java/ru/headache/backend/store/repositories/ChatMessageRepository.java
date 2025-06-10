package ru.headache.backend.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.headache.backend.store.entities.ChatMessage;
import ru.headache.backend.store.entities.Room;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
    List<ChatMessage> findByRoomOrderByTimestamp(Room room);
}