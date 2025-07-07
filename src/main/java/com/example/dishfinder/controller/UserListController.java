package com.example.dishfinder.controller;

import com.example.dishfinder.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lists")
@RequiredArgsConstructor
public class UserListController {

    private final UserListService userListService;

    @PostMapping("/save-dish")
    public void saveDish(@RequestParam Long dishId, @RequestParam Long userId) {
        userListService.saveDish(userId, dishId);
    }

    @PostMapping("/save-restaurant")
    public void saveRestaurant(@RequestParam Long restaurantId, @RequestParam Long userId) {
        userListService.saveRestaurant(userId, restaurantId);
    }
}
