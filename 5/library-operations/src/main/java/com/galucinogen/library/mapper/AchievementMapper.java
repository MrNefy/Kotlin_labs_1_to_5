package com.galucinogen.library.mapper;

import com.galucinogen.library.dto.AchievementDto;
import com.galucinogen.library.entity.Achievement;
import com.galucinogen.library.entity.Member;

public class AchievementMapper {

    // Entity → DTO
    public static AchievementDto toDto(Achievement achievement) {
        return new AchievementDto(
                achievement.getId(),
                achievement.getTitle(),
                achievement.getDescription(),
                achievement.getAchievedDate(),
                achievement.getMember() != null
                        ? achievement.getMember().getId()
                        : null
        );
    }

    // DTO → Entity
    public static Achievement toEntity(AchievementDto dto, Member member) {
        return new Achievement(
                dto.getTitle(),
                dto.getDescription(),
                dto.getAchievedDate(),
                member
        );
    }
}
