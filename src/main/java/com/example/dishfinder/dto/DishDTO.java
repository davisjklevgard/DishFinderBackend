
package com.example.dishfinder.dto;

public class DishDTO {
    private Long id;
    private String name;
    private String restaurantName;

    private String description;

    private double overallScore;

    public DishDTO() {}

    public DishDTO(Long id, String name, String restaurantName, String description, double overallScore) {
        this.id = id;
        this.name = name;
        this.restaurantName = restaurantName;
        this.description = description;
        this.overallScore = overallScore;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }
}

