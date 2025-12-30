package com.galucinogen.library.service;

import com.galucinogen.library.entity.Loan;
import java.util.List;

public interface LoanService {
    List<Loan> findAll();
    Loan issueLoan(Loan loan);
    void closeLoan(Long id);
}
