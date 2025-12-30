package com.galucinogen.library.mapper;

import com.galucinogen.library.dto.EventDto;
import com.galucinogen.library.entity.Event;
import com.galucinogen.library.entity.Member;
import com.galucinogen.library.entity.Resource;

public class EventMapper {

    // Entity → DTO
    public static EventDto toDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getEventDate(),   // ← ВАЖНО: getEventDate()
                event.getMember() != null ? event.getMember().getId() : null,
                event.getResource() != null ? event.getResource().getId() : null
        );
    }

    // DTO → Entity
    public static Event toEntity(EventDto dto, Member member, Resource resource) {
        return new Event(
                dto.getTitle(),        // ← требует getter
                dto.getDescription(),  // ← требует getter
                dto.getEventDate(),    // ← требует getter
                member,
                resource
        );
    }
}
