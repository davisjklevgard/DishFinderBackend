package com.example.dishfinder.model;


import com.example.dishfinder.dto.DishDTO;
import com.example.dishfinder.dto.RestaurantDTO;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {

    private List<RestaurantDTO> restaurants = new ArrayList<>();
    private List<DishDTO> dishes = new ArrayList<>();

    public SearchResponse() {
    }

    public SearchResponse(List<RestaurantDTO> restaurants, List<DishDTO> dishes) {
        this.restaurants = restaurants;
        this.dishes = dishes;
    }

    public List<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }

    public List<DishDTO> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishDTO> dishes) {
        this.dishes = dishes;
    }
}
