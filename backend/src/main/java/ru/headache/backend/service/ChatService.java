package ru.headache.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.headache.backend.store.entities.ChatMessage;
import ru.headache.backend.store.entities.Room;
import ru.headache.backend.store.repositories.ChatMessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatRepo;

    public void saveMessage(ChatMessage message) {
        chatRepo.save(message);
    }

    public List<ChatMessage> getChatHistory(Room room) {
        return chatRepo.findByRoomOrderByTimestamp(room);
    }
}
