package com.example.dishfinder.service;


import com.example.dishfinder.dto.DishDTO;
import com.example.dishfinder.model.Dish;
import com.example.dishfinder.repo.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public List<DishDTO> search(String term, int limit) {
        // 1. Query DB for dishes with name LIKE %term%
        List<Dish> matches = dishRepository.findByNameContainingIgnoreCase(term);

        // 2. Limit results in Java or in query (better to limit in query)
        return matches.stream()
                .limit(limit)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private DishDTO toDto(Dish dish) {
        return new DishDTO(dish.getId(), dish.getName(), dish.getRestaurant(), dish.getDescription(), dish.getOverallScore());
    }
}

