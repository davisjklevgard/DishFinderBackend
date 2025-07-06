package com.example.dishfinder.dto;


public class RestaurantDTO {
    private Long id;
    private String name;

    private String address;

    public RestaurantDTO() {}

    public RestaurantDTO(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

