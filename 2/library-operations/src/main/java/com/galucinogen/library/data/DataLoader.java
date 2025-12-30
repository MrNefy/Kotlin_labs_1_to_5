package com.galucinogen.library.data;

import com.galucinogen.library.entity.*;
import com.galucinogen.library.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final ResourceRepository resourceRepository;
    private final EventRepository eventRepository;
    private final AchievementRepository achievementRepository;

    public DataLoader(
            MemberRepository memberRepository,
            ResourceRepository resourceRepository,
            EventRepository eventRepository,
            AchievementRepository achievementRepository
    ) {
        this.memberRepository = memberRepository;
        this.resourceRepository = resourceRepository;
        this.eventRepository = eventRepository;
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void run(String... args) {

        // ===== Members =====
        Member member1 = new Member(
                "Иван",
                "Иванов",
                "ivan@mail.com",
                LocalDate.now()
        );

        Member member2 = new Member(
                "Анна",
                "Петрова",
                "anna@mail.com",
                LocalDate.now()
        );

        memberRepository.save(member1);
        memberRepository.save(member2);

        // ===== Resources =====
        Resource room = new Resource(
                "Конференц-зал",
                "Помещение",
                1
        );

        Resource projector = new Resource(
                "Проектор",
                "Оборудование",
                2
        );

        resourceRepository.save(room);
        resourceRepository.save(projector);

        // ===== Events =====
        Event event1 = new Event(
                "Лекция по Java",
                "Введение в Spring Boot",
                LocalDateTime.now().plusDays(1),
                member1,
                room
        );

        Event event2 = new Event(
                "Практика по SQL",
                "Работа с MySQL",
                LocalDateTime.now().plusDays(2),
                member2,
                projector
        );

        eventRepository.save(event1);
        eventRepository.save(event2);

        // ===== Achievements =====
        Achievement achievement1 = new Achievement(
                "Первое мероприятие",
                "Участие в первом событии",
                LocalDate.now(),
                member1
        );

        Achievement achievement2 = new Achievement(
                "Активный участник",
                "Посещение двух мероприятий",
                LocalDate.now(),
                member2
        );

        achievementRepository.save(achievement1);
        achievementRepository.save(achievement2);

        System.out.println("DataLoader: тестовые данные успешно добавлены");
    }
}
