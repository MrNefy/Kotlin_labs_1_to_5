package com.galucinogen.library.controller;

import com.galucinogen.library.dto.LoginRequest;
import com.galucinogen.library.entity.Member;
import com.galucinogen.library.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MemberRepository memberRepository;

    public AuthController(AuthenticationManager authenticationManager,
                          MemberRepository memberRepository) {
        this.authenticationManager = authenticationManager;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse
    ) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        HttpSessionSecurityContextRepository repo =
                new HttpSessionSecurityContextRepository();
        repo.saveContext(context, httpRequest, httpResponse);

        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow();

        return ResponseEntity.ok(Map.of(
                "message", "Успешный вход",
                "memberId", member.getId(),
                "email", member.getEmail(),
                "role", "USER"
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Выход выполнен");
    }
}
