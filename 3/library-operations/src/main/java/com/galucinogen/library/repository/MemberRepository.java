package com.galucinogen.library.repository;

import com.galucinogen.library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByLastNameContainingIgnoreCase(String lastName);

    Optional<Member> findByEmail(String email);
}
