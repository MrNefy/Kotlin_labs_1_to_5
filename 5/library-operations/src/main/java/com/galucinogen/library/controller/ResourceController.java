package com.galucinogen.library.controller;

import com.galucinogen.library.dto.ResourceDto;
import com.galucinogen.library.mapper.ResourceMapper;
import com.galucinogen.library.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public ResponseEntity<List<ResourceDto>> getAllResources() {
        List<ResourceDto> resources = resourceService.findAll()
                .stream()
                .map(ResourceMapper::toDto)
                .toList();

        return ResponseEntity.ok(resources);
    }
}
