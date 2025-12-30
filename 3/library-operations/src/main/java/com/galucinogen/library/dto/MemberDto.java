package com.galucinogen.library.dto;

import java.time.LocalDate;

public class MemberDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;

    public MemberDto() {}

    public MemberDto(Long id,
                     String firstName,
                     String lastName,
                     String email,
                     LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
