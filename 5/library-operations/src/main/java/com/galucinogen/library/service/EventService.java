package com.galucinogen.library.service;

import com.galucinogen.library.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

    void deleteById(Long id);
}
