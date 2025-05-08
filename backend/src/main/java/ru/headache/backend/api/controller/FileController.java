package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.FileDto;
import ru.headache.backend.service.FileService;

import java.util.List;

@RequestMapping("/file")
@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @GetMapping
    public List<FileDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public FileDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public FileDto save(@RequestBody FileDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
