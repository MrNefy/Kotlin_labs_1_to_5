package com.galucinogen.library.controller;

import com.galucinogen.library.dto.AchievementDto;
import com.galucinogen.library.mapper.AchievementMapper;
import com.galucinogen.library.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public ResponseEntity<List<AchievementDto>> getAll() {
        List<AchievementDto> result = achievementService.findAll()
                .stream()
                .map(AchievementMapper::toDto)
                .toList();

        return ResponseEntity.ok(result);
    }
}
