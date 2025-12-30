package com.galucinogen.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate achievedDate;

    @ManyToOne
    private Member member;

    protected Achievement() {}

    public Achievement(String title, String description,
                       LocalDate achievedDate,
                       Member member) {
        this.title = title;
        this.description = description;
        this.achievedDate = achievedDate;
        this.member = member;
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

    public LocalDate getAchievedDate() {
        return achievedDate;
    }

    public Member getMember() {
        return member;
    }
}
