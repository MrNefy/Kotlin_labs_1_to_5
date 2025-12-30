package com.galucinogen.library.service;

import com.galucinogen.library.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<Member> findAll();

    Optional<Member> findById(Long id);

    Member save(Member member);

    void deleteById(Long id);
}
