package com.example.dishfinder.resource;

import com.example.dishfinder.model.Dish;
import com.example.dishfinder.model.Restaurant;
import com.example.dishfinder.model.SearchResultItem;
import com.example.dishfinder.repo.DishRepository;
import com.example.dishfinder.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private DishRepository dishRepo;

    @GetMapping
    public List<SearchResultItem> search(@RequestParam String query) {
        List<SearchResultItem> results = new ArrayList<>();

        // Add matching restaurants
        List<Restaurant> restaurants = restaurantRepo.findByNameContainingIgnoreCase(query);
        for (Restaurant restaurant : restaurants) {
            results.add(new SearchResultItem("restaurant", restaurant.getName(), restaurant.getId()));
        }

        // Add matching dishes
        List<Dish> dishes = dishRepo.findByNameContainingIgnoreCase(query);
        for (Dish dish : dishes) {
            results.add(new SearchResultItem("dish", dish.getName(), dish.getRestaurant(), dish.getId()));
        }

        return results;
    }
}
