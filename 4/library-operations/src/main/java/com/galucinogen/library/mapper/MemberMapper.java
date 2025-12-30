package com.galucinogen.library.mapper;

import com.galucinogen.library.dto.MemberDto;
import com.galucinogen.library.entity.Member;

public class MemberMapper {

    // Entity → DTO
    public static MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getEmail(),
                null,
                member.getRegistrationDate()
        );
    }

    // DTO → Entity
    public static Member toEntity(MemberDto dto) {
        return new Member(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRegistrationDate()
        );
    }
}
