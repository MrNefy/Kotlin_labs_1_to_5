package com.galucinogen.library.service;

import com.galucinogen.library.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {

    List<Resource> findAll();

    Optional<Resource> findById(Long id);

    Resource save(Resource resource);

    void deleteById(Long id);
}
