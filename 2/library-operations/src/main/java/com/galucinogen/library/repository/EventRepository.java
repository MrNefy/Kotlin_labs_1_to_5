package com.galucinogen.library.repository;

import com.galucinogen.library.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByMemberId(Long memberId);

    List<Event> findByEventDateAfter(LocalDateTime dateTime);
}
