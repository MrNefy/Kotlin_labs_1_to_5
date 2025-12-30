package com.galucinogen.library.controller;

import com.galucinogen.library.entity.Reader;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {

    private final List<Reader> readers = List.of(
            new Reader("Ivan Petrov", "ivan@mail.com"),
            new Reader("Anna Smirnova", "anna@mail.com")
    );

    @GetMapping
    public List<Reader> getAllReaders() {
        return readers;
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable int id) {
        return readers.get(id - 1);
    }
}
