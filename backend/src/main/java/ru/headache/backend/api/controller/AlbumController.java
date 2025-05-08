package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.AlbumDto;
import ru.headache.backend.service.AlbumService;

import java.util.List;

@RequestMapping("/album")
@RestController
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @GetMapping
    public List<AlbumDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public AlbumDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public AlbumDto save(@RequestBody AlbumDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
