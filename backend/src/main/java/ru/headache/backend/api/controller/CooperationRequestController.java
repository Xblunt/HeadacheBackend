package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.CooperationRequestDto;
import ru.headache.backend.service.CooperationRequestService;

import java.util.List;

@RequestMapping("/cooperationRequest")
@RestController
@RequiredArgsConstructor
public class CooperationRequestController {
    private final CooperationRequestService service;

    @GetMapping
    public List<CooperationRequestDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public CooperationRequestDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public CooperationRequestDto save(@RequestBody CooperationRequestDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
