package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.headache.backend.api.dto.AudioStateDTO;
import ru.headache.backend.service.AudioStateService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AudioController {
    private final AudioStateService audioStateService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/audio.play")
    public void play(@Payload AudioStateDTO dto, Principal principal) {
        audioStateService.updateAudioState(dto.getRoomId(), dto.getSongId(), dto.getPosition(), true);
        messagingTemplate.convertAndSend("/topic/audio/" + dto.getRoomId(), dto);
    }

    @MessageMapping("/audio.pause")
    public void pause(@Payload AudioStateDTO dto, Principal principal) {
        dto.setPlaying(false);
        audioStateService.updateAudioState(dto.getRoomId(), dto.getSongId(), dto.getPosition(), false);
        messagingTemplate.convertAndSend("/topic/audio/" + dto.getRoomId(), dto);
    }
}
