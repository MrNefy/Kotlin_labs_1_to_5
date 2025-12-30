package com.galucinogen.library.controller;

import com.galucinogen.library.entity.Achievement;
import com.galucinogen.library.repository.AchievementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementRepository achievementRepository;

    public AchievementController(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @GetMapping
    public List<Achievement> getAll() {
        return achievementRepository.findAll();
    }
}
