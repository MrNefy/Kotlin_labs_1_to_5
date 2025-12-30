package com.galucinogen.library.controller;

import com.galucinogen.library.dto.EventDto;
import com.galucinogen.library.mapper.EventMapper;
import com.galucinogen.library.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.findAll()
                .stream()
                .map(EventMapper::toDto)
                .toList();

        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        return eventService.findById(id)
                .map(EventMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
