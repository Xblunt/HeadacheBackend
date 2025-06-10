package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.headache.backend.api.dto.AudioStateDTO;
import ru.headache.backend.api.dto.ChatMessageDTO;
import ru.headache.backend.service.AudioStateService;
import ru.headache.backend.service.ChatService;
import ru.headache.backend.service.UserService;
import ru.headache.backend.store.entities.ChatMessage;
import ru.headache.backend.store.entities.Room;
import ru.headache.backend.store.repositories.RoomRepository;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;
    private final RoomRepository roomRepo;
    private final UserService userRoomService;
    private final AudioStateService audioStateService;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageDTO dto,
                            Principal principal) {
        dto.setSender(principal.getName());

        Room room = roomRepo.findById(dto.getRoomId()).orElseThrow();

        ChatMessage message = new ChatMessage();
        message.setSender(dto.getSender());
        message.setContent(dto.getContent());
        message.setRoom(room);

        chatService.saveMessage(message);

        messagingTemplate.convertAndSend("/topic/" + dto.getRoomId(), dto);
    }

    @MessageMapping("/chat.join")
    public void joinRoom(@Payload ChatMessageDTO dto,
                         Principal principal) {
        dto.setSender(principal.getName());

        Room room = roomRepo.findById(dto.getRoomId()).orElseThrow();

        // Отправляем историю чата
        List<ChatMessage> history = chatService.getChatHistory(room);
        for (ChatMessage msg : history) {
            ChatMessageDTO messageDTO = new ChatMessageDTO();
            messageDTO.setSender(msg.getSender());
            messageDTO.setContent(msg.getContent());
            messageDTO.setRoomId(msg.getRoom().getUuid());

            messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/messages", messageDTO);
        }

        // Отправляем состояние аудио
        audioStateService.getAudioState(dto.getRoomId())
                .ifPresent(state -> {
                    AudioStateDTO audioDTO = new AudioStateDTO();
                    audioDTO.setSongId(state.getUuid());
                    audioDTO.setPosition(state.getPosition());
                    audioDTO.setPlaying(state.isPlaying());
                    audioDTO.setRoomId(state.getRoom().getUuid());

                    messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/audio", audioDTO);
                });

        // Уведомление о входе
        ChatMessageDTO systemMsg = new ChatMessageDTO();
        systemMsg.setSender("system");
        systemMsg.setContent("User " + principal.getName() + " joined the room.");
        systemMsg.setRoomId(dto.getRoomId());
        messagingTemplate.convertAndSend("/topic/" + dto.getRoomId(), systemMsg);
    }
}
