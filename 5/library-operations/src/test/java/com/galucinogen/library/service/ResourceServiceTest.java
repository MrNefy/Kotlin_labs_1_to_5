package com.galucinogen.library.service;

import com.galucinogen.library.entity.Resource;
import com.galucinogen.library.repository.ResourceRepository;
import com.galucinogen.library.service.impl.ResourceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResourceServiceTest {

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceServiceImpl resourceService;

    @Test
    void findAll_ShouldReturnResources() {
        Resource resource = new Resource("Room", "Space", 10);
        when(resourceRepository.findAll()).thenReturn(List.of(resource));

        List<Resource> result = resourceService.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void findById_ShouldReturnResource() {
        Resource resource = new Resource("Room", "Space", 10);
        when(resourceRepository.findById(1L)).thenReturn(Optional.of(resource));

        Optional<Resource> result = resourceService.findById(1L);

        assertTrue(result.isPresent());
    }
}
