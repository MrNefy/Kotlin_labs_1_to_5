package com.galucinogen.library.dto;

import java.time.LocalDateTime;

public class EventDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private Long memberId;
    private Long resourceId;

    public EventDto() {}

    public EventDto(Long id, String title, String description,
                    LocalDateTime eventDate, Long memberId, Long resourceId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.memberId = memberId;
        this.resourceId = resourceId;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDateTime getEventDate() { return eventDate; }
    public Long getMemberId() { return memberId; }
    public Long getResourceId() { return resourceId; }
}
