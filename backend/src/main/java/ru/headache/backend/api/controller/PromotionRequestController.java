package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.PromotionRequestDto;
import ru.headache.backend.service.PromotionRequestService;

import java.util.List;

@RequestMapping("/promotionRequest")
@RestController
@RequiredArgsConstructor
public class PromotionRequestController {
    private final PromotionRequestService service;

    @GetMapping
    public List<PromotionRequestDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public PromotionRequestDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public PromotionRequestDto save(@RequestBody PromotionRequestDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
