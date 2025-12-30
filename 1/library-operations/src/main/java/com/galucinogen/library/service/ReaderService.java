package com.galucinogen.library.service;

import com.galucinogen.library.entity.Reader;
import java.util.List;
import java.util.Optional;

public interface ReaderService {
    List<Reader> findAll();
    Optional<Reader> findById(Long id);
    Reader save(Reader reader);
    void deleteById(Long id);
}
