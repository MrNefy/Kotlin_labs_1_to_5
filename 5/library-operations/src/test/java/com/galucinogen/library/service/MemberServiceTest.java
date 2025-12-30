package com.galucinogen.library.service;

import com.galucinogen.library.entity.Member;
import com.galucinogen.library.repository.MemberRepository;
import com.galucinogen.library.service.impl.MemberServiceImpl;
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
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        member = new Member(
                "John",
                "Doe",
                "john@test.com",
                "password",
                LocalDate.now()
        );
    }

    @Test
    void findAll_ShouldReturnMembers() {
        when(memberRepository.findAll()).thenReturn(List.of(member));

        List<Member> result = memberService.findAll();

        assertEquals(1, result.size());
        verify(memberRepository).findAll();
    }

    @Test
    void findById_WhenExists_ShouldReturnMember() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> result = memberService.findById(1L);

        assertTrue(result.isPresent());
        verify(memberRepository).findById(1L);
    }

    @Test
    void findById_WhenNotExists_ShouldReturnEmpty() {
        when(memberRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Member> result = memberService.findById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void save_ShouldCallRepository() {
        when(memberRepository.save(member)).thenReturn(member);

        Member saved = memberService.save(member);

        assertEquals(member, saved);
        verify(memberRepository).save(member);
    }

    @Test
    void deleteById_ShouldCallRepository() {
        memberService.deleteById(1L);

        verify(memberRepository).deleteById(1L);
    }
}
