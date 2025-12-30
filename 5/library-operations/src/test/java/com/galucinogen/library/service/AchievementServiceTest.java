package com.galucinogen.library.service;

import com.galucinogen.library.entity.Achievement;
import com.galucinogen.library.entity.Member;
import com.galucinogen.library.repository.AchievementRepository;
import com.galucinogen.library.service.impl.AchievementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AchievementServiceTest {

    @Mock
    private AchievementRepository achievementRepository;

    @InjectMocks
    private AchievementServiceImpl achievementService;

    private Achievement achievement;

    @BeforeEach
    void setUp() {
        Member member = new Member(
                "John",
                "Doe",
                "john@test.com",
                "password",
                LocalDate.now()
        );

        achievement = new Achievement(
                "First Achievement",
                "Test description",
                LocalDate.now(),
                member
        );
    }

    @Test
    void findAll_ShouldReturnAchievements() {
        when(achievementRepository.findAll()).thenReturn(List.of(achievement));

        List<Achievement> result = achievementService.findAll();

        assertEquals(1, result.size());
        verify(achievementRepository).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnAchievement() {
        when(achievementRepository.findById(1L))
                .thenReturn(Optional.of(achievement));

        Optional<Achievement> result = achievementService.findById(1L);

        assertTrue(result.isPresent());
        verify(achievementRepository).findById(1L);
    }

    @Test
    void findById_WhenNotExists_ShouldReturnEmpty() {
        when(achievementRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Achievement> result = achievementService.findById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void save_ShouldReturnSavedAchievement() {
        when(achievementRepository.save(achievement))
                .thenReturn(achievement);

        Achievement saved = achievementService.save(achievement);

        assertEquals("First Achievement", saved.getTitle());
        verify(achievementRepository).save(achievement);
    }

    @Test
    void deleteById_ShouldCallRepository() {
        achievementService.deleteById(1L);

        verify(achievementRepository).deleteById(1L);
    }
}
