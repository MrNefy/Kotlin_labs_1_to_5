package com.galucinogen.library.service.impl;

import com.galucinogen.library.entity.Achievement;
import com.galucinogen.library.repository.AchievementRepository;
import com.galucinogen.library.service.AchievementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    @Override
    public Optional<Achievement> findById(Long id) {
        return achievementRepository.findById(id);
    }

    @Override
    public Achievement save(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public void deleteById(Long id) {
        achievementRepository.deleteById(id);
    }
}
