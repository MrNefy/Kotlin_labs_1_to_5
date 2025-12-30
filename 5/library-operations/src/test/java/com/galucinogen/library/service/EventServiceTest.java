package com.galucinogen.library.service;

import com.galucinogen.library.entity.Event;
import com.galucinogen.library.entity.Member;
import com.galucinogen.library.entity.Resource;
import com.galucinogen.library.repository.EventRepository;
import com.galucinogen.library.service.impl.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event;

    @BeforeEach
    void setUp() {
        Member member = new Member(
                "Jane",
                "Doe",
                "jane@test.com",
                "password",
                LocalDate.now()
        );

        Resource resource = new Resource(
                "Conference Room",
                "Room",
                5
        );

        event = new Event(
                "Meeting",
                "Project discussion",
                LocalDateTime.now(),
                member,
                resource
        );
    }

    @Test
    void findAll_ShouldReturnEvents() {
        when(eventRepository.findAll()).thenReturn(List.of(event));

        List<Event> result = eventService.findAll();

        assertEquals(1, result.size());
        verify(eventRepository).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnEvent() {
        when(eventRepository.findById(1L))
                .thenReturn(Optional.of(event));

        Optional<Event> result = eventService.findById(1L);

        assertTrue(result.isPresent());
        verify(eventRepository).findById(1L);
    }

    @Test
    void findById_WhenNotExists_ShouldReturnEmpty() {
        when(eventRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Event> result = eventService.findById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void save_ShouldReturnSavedEvent() {
        when(eventRepository.save(event))
                .thenReturn(event);

        Event saved = eventService.save(event);

        assertEquals("Meeting", saved.getTitle());
        verify(eventRepository).save(event);
    }

    @Test
    void deleteById_ShouldCallRepository() {
        eventService.deleteById(1L);

        verify(eventRepository).deleteById(1L);
    }
}
