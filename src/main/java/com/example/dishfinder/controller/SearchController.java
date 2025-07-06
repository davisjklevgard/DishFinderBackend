package com.example.dishfinder.controller;

import com.example.dishfinder.service.DishService;
import com.example.dishfinder.service.RestaurantService;
import com.example.dishfinder.dto.DishDTO;
import com.example.dishfinder.dto.RestaurantDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final DishService dishService;
    private final RestaurantService restaurantService;

    @GetMapping
    public Map<String, List<?>> search(@RequestParam String term) {
        // 1. delegate to services
        List<DishDTO> dishes = dishService.search(term, 20);
        List<RestaurantDTO> restaurants = restaurantService.search(term, 20);
        // 2. bundle result for frontend differentiation
        return Map.of("dishes", dishes, "restaurants", restaurants);
    }
}


