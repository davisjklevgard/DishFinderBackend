package com.example.dishfinder.resource;

import com.example.dishfinder.model.Dish;
import com.example.dishfinder.repo.DishRepository;
import com.example.dishfinder.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@CrossOrigin(origins = "http://localhost:4200")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        return dishRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Dish> getDishesByRestaurant(@PathVariable Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        // You can validate restaurant exists before saving
        if (dish.getRestaurantId() != null &&
                dish.getRestaurant() != null &&
                !restaurantRepository.existsById(dish.getRestaurantId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dishRepository.save(dish));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody Dish updatedDish) {
        return dishRepository.findById(id).map(dish -> {
            dish.setName(updatedDish.getName());
            dish.setDescription(updatedDish.getDescription());
            dish.setPrice(updatedDish.getPrice());
            dish.setRestaurant(updatedDish.getRestaurant());
            return ResponseEntity.ok(dishRepository.save(dish));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        return dishRepository.findById(id).map(dish -> {
            dishRepository.delete(dish);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

