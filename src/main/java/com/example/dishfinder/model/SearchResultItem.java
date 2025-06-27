package com.example.dishfinder.model;

public class SearchResultItem {
    private String type; // "restaurant" or "dish"
    private String name;
    private String restaurantName; // only for dishes
    private Long id;

    // Constructors
    public SearchResultItem(String type, String name, String restaurantName, Long id) {
        this.type = type;
        this.name = name;
        this.restaurantName = restaurantName;
        this.id = id;
    }

    public SearchResultItem(String type, String name, Long id) {
        this(type, name, null, id);
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

