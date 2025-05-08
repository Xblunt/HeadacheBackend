package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.TagDto;
import ru.headache.backend.service.TagService;

import java.util.List;

@RequestMapping("/tag")
@RestController
@RequiredArgsConstructor
public class TagController {
    private final TagService service;

    @GetMapping
    public List<TagDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public TagDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public TagDto save(@RequestBody TagDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
