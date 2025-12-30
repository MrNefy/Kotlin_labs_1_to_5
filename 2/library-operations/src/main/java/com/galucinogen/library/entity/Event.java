package com.galucinogen.library.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    protected Event() {}

    public Event(String title,
                 String description,
                 LocalDateTime eventDate,
                 Member member,
                 Resource resource) {
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.member = member;
        this.resource = resource;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public Member getMember() {
        return member;
    }

    public Resource getResource() {
        return resource;
    }
}
