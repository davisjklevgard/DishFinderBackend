package com.example.dishfinder.service;

import org.springframework.stereotype.Service;

@Service
public class UserListService {

    public void saveDish(Long userId, Long dishId) {
        // TODO: Implement save logic, e.g., insert row into user_dish_list table
        System.out.println("Saving dish " + dishId + " for user " + userId);
    }

    public void saveRestaurant(Long userId, Long restaurantId) {
        // TODO: Implement save logic, e.g., insert row into user_restaurant_list table
        System.out.println("Saving restaurant " + restaurantId + " for user " + userId);
    }
}

