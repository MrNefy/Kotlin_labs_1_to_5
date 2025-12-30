package com.galucinogen.library.dto;

import java.time.LocalDate;

public class AchievementDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate achievedDate;
    private Long memberId;

    public AchievementDto() {}

    public AchievementDto(Long id,
                          String title,
                          String description,
                          LocalDate achievedDate,
                          Long memberId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.achievedDate = achievedDate;
        this.memberId = memberId;
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

    public Long getMemberId() {
        return memberId;
    }
}
