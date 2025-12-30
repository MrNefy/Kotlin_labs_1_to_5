package com.galucinogen.library.dto;

public class ResourceDto {

    private Long id;
    private String name;
    private String type;
    private int quantity;

    public ResourceDto() {}

    public ResourceDto(Long id,
                       String name,
                       String type,
                       int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }
}
