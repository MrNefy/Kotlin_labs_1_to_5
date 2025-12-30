package com.galucinogen.library.controller;

import com.galucinogen.library.entity.Loan;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final List<Loan> loans;

    public LoanController() {
        Loan loan1 = new Loan();
        loan1.setIssuedAt(LocalDateTime.now());
        loan1.setDueAt(LocalDateTime.now().plusDays(14));
        loan1.setStatus(Loan.LoanStatus.ACTIVE);

        Loan loan2 = new Loan();
        loan2.setIssuedAt(LocalDateTime.now().minusDays(3));
        loan2.setDueAt(LocalDateTime.now().plusDays(7));
        loan2.setStatus(Loan.LoanStatus.RETURNED);

        loans = List.of(loan1, loan2);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loans;
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable int id) {
        return loans.get(id - 1);
    }
}
