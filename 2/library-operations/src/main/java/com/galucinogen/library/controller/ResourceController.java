package com.galucinogen.library.controller;

import com.galucinogen.library.entity.Resource;
import com.galucinogen.library.repository.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    private final ResourceRepository resourceRepository;

    public ResourceController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
