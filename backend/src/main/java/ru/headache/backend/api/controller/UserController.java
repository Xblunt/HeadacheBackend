package ru.headache.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.headache.backend.api.dto.UserDto;
import ru.headache.backend.service.UserService;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<UserDto> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{uuid}")
    public UserDto getByUUID(@PathVariable("uuid") String uuid)
    {
        return service.getByUUID(uuid);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto dto)
    {
        return service.save(dto);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable("uuid") String uuid)
    {
        return service.delete(uuid);
    }
}
