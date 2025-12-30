package com.galucinogen.library.mapper;

import com.galucinogen.library.dto.ResourceDto;
import com.galucinogen.library.entity.Resource;

public class ResourceMapper {

    // Entity → DTO
    public static ResourceDto toDto(Resource resource) {
        return new ResourceDto(
                resource.getId(),
                resource.getName(),
                resource.getType(),
                resource.getQuantity()
        );
    }

    // DTO → Entity
    public static Resource toEntity(ResourceDto dto) {
        return new Resource(
                dto.getName(),
                dto.getType(),
                dto.getQuantity()
        );
    }
}
