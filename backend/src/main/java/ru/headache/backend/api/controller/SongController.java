package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.SongDto;
import ru.headache.backend.service.SongService;

import java.util.List;

@RequestMapping("/song")
@RestController
@RequiredArgsConstructor
public class SongController {
    private final SongService service;

    @GetMapping
    public List<SongDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public SongDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public SongDto save(@RequestBody SongDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
